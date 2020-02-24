package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.DAOFactory;
import persistenceDao.UtenteDao;

public class EliminaProfilo extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		UtenteDao uDao = factory.getUtenteDao();
		String email=req.getParameter("email");
		uDao.delete(email);
		req.getSession().setAttribute("utente", null);
		resp.sendRedirect("byebye.jsp");




	}

}
