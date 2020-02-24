package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Automobile;
import persistence.DAOFactory;
import persistenceDao.AutomobileDao;

public class LeNostreAuto extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		AutomobileDao uDao = factory.getAutomobileDao();
		String autoDaCercare=req.getParameter("ricerca");

	    List<Automobile> leNostreAuto= uDao.listaAutomobili();

	    
	    req.getSession().setAttribute("automobiliDisponibili", leNostreAuto);
	    
		
		RequestDispatcher rd = req.getRequestDispatcher("le-nostre-auto.jsp"); 
		rd.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.sendRedirect("index.jsp");

	}

}
