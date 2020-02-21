package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Feedback;
import persistence.DAOFactory;
import persistenceDao.AutomobileDao;
import persistenceDao.FeedbackDao;
import persistenceDao.OrdineDao;
import persistenceDao.UtenteDao;

public class PostaFeedback extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		String loggedUser= (String) req.getSession().getAttribute("loggedUserPF");
		String modello=  (String) req.getSession().getAttribute("modelloPF");
		String targa= (String) req.getSession().getAttribute("targaPF");
		String commento=req.getParameter("commento");
		System.out.println(targa+" "+loggedUser + " " + modello + " "+commento);

		AutomobileDao autoDao = factory.getAutomobileDao();
		FeedbackDao feedbackDao = factory.getFeedbackDAO();
		UtenteDao uDao=factory.getUtenteDao();
		OrdineDao ordineDao=factory.getOrdineDAO();
		String id=ordineDao.getIDbyTarga(targa);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  

		Feedback feedback=new Feedback(id, commento,dtf.format(now));
		feedbackDao.save(feedback);
		autoDao.auto_valutata_con(feedback, targa);
		ordineDao.ordine_relativo_a_feedback(feedback, id);
		uDao.feedback_rilasciato_da(loggedUser, feedback);	


		RequestDispatcher rd = req.getRequestDispatcher("i-miei-ordini.jsp"); //queste mi servono per  ricaricare la pagina
		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	}
}

