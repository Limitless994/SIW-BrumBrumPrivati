package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class RilasciaFeedback extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("i-miei-ordini.jsp"); 
		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		FeedbackDao f=factory.getFeedbackDAO();
		String loggedUser=  req.getParameter("loggedUser");
		String modello=  req.getParameter("modello");
		String targa= req.getParameter("targa");

		req.getSession().setAttribute("modelloPF", modello);
		req.getSession().setAttribute("targaPF", targa);
		req.getSession().setAttribute("loggedUserPF", loggedUser);
		
		if(f.giaEsistente(targa, loggedUser)){
			System.out.println("Gia rilasciato");
			RequestDispatcher rd = req.getRequestDispatcher("feedbackAlreadyExist.jsp");
			rd.forward(req, resp);
		}else {

		RequestDispatcher rd = req.getRequestDispatcher("LasciaFeedback.jsp");
		rd.forward(req, resp);
		}
		
		
	}
}
