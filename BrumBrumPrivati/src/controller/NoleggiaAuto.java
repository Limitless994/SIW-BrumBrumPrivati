package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Automobile;
import model.Ordine;
import model.Pagamento;
import model.Spedizione;
import persistence.DAOFactory;
import persistenceDao.AutomobileDao;
import persistenceDao.OrdineDao;
import persistenceDao.PagamentoDao;
import persistenceDao.SpedizioneDao;

public class NoleggiaAuto extends HttpServlet {
	
	private String targaAuto=null;
	
	public String getTargaAuto() {
		return targaAuto;
	}

	public void setTargaAuto(String targaAuto) {
		this.targaAuto = targaAuto;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AVVIATA SERVLET NOLEGGIO");
		

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		AutomobileDao autoDao = factory.getAutomobileDao();

		String targa=targaAuto,loggedUser=null,indirizzo="Via Speronari, 8, 20123 Milano MI", modalitaSpedizione="ritiro in sede",sede=null,metodoPagamento="Bonifico",iban=null,fileAffidabilita=null;

		List<Automobile> autoDaComprare = new ArrayList<Automobile>();
		double totaleOrdine=0;


		String email=req.getParameter("email");
		metodoPagamento = req.getParameter("pagamento");
		iban = req.getParameter("iban");
		fileAffidabilita = req.getParameter("immagine");
		loggedUser=req.getParameter("email");
		String nome= req.getParameter("nome")+" ";
		String cognome= req.getParameter("cognome");
		
		req.getSession().setAttribute("nome", nome);
		req.getSession().setAttribute("cognome", cognome);
		req.getSession().setAttribute("indirizzo", indirizzo);
		req.getSession().setAttribute("email", email);
		req.getSession().setAttribute("metodoPagamento", metodoPagamento);
		req.getSession().setAttribute("iban", iban);
		req.getSession().setAttribute("totaleOrdine", totaleOrdine);
		req.getSession().setAttribute("targa", targaAuto);
		req.getSession().setAttribute("spedizione", modalitaSpedizione); 
		req.getSession().setAttribute("metodoPagamento", metodoPagamento);
		
		Automobile automobile=autoDao.find(targa);
		req.getSession().setAttribute("AutomobileAcquistata", automobile); 
			
		boolean noleggio= true;
		req.getSession().setAttribute("noleggio",noleggio );
		
		resp.sendRedirect("riepilogoOrdine.jsp");
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		targaAuto=req.getParameter("targa");

		RequestDispatcher rd = req.getRequestDispatcher("NoleggiaAuto.jsp");
		rd.forward(req, resp);
	}
}