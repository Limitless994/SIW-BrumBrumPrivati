package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ComplexAutomobile;

import persistence.DAOFactory;
import persistenceDao.OrdineDao;

public class StoricoOrdini extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loggedUser=  req.getParameter("emailLoggato");

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		OrdineDao ordineDao=factory.getOrdineDAO();
		List<ComplexAutomobile> autoOrdinate= ordineDao.storicoOrdini(loggedUser);
		req.getSession().setAttribute("storicoOrdini", autoOrdinate); 
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("i-miei-ordini.jsp"); 
		rd.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.jsp");

	}

}
