package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComplexAutomobile;
import model.Statistiche;
import persistence.DAOFactory;
import persistenceDao.FeedbackDao;
import persistenceDao.OrdineDao;
import persistenceDao.UtenteDao;

@SuppressWarnings("serial")
public class CaricaStatAdmin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		String today = LocalDateTime.now().toString();
				
		OrdineDao oDao= factory.getOrdineDAO();
		UtenteDao uDao = factory.getUtenteDao();
		FeedbackDao fDao = factory.getFeedbackDAO();
		int totOrdiniEffettuati=oDao.listaAutoAcquistate().size()+oDao.listaAutoNoleggiate().size();
		int totIncassi=0;
		int questoMese=0;
		int[] storicoNumerAutoVendute = {12,3,4,5,15};
		int[] storicoIncassoMese = {100000, 65000, 43000};
		
		for(ComplexAutomobile a: oDao.listaAutoAcquistate()) {
			totIncassi+=Integer.parseInt(a.getPrezzovendita());
			if(today.charAt(5)==a.getData().charAt(5) && today.charAt(6)==a.getData().charAt(6)) questoMese+=1;
		}

		for(ComplexAutomobile a: oDao.listaAutoNoleggiate()) {
			totIncassi+=Integer.parseInt(a.getPrezzonoleggio());
			if(today.charAt(5)==a.getData().charAt(5) && today.charAt(6)==a.getData().charAt(6)) questoMese+=1;
		}
		
		Statistiche stat=new Statistiche(uDao.getNumeroUtentiRegistrati(), totOrdiniEffettuati, questoMese, totIncassi, oDao.listaAutoAcquistate(), oDao.listaAutoNoleggiate(), fDao.getAllFeedback(), storicoNumerAutoVendute, storicoIncassoMese);
		req.getSession().setAttribute("statistiche", stat);
		RequestDispatcher rd = req.getRequestDispatcher("statisticheADMIN.jsp"); 
		rd.forward(req, resp);
	}
}
