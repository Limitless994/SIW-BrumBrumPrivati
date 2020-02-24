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
import persistence.DAOFactory;
import persistenceDao.AutomobileDao;

public class Cerca extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.sendRedirect("index.jsp");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println();
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		AutomobileDao uDao = factory.getAutomobileDao();
		String autoDaCercare=null;
		List<Automobile> autom=new ArrayList<Automobile>();
		autoDaCercare=req.getParameter("ricerca");
		
		if(autoDaCercare.length()>=1)
	    autom= uDao.cercaAuto(autoDaCercare);
	    
	    req.getSession().setAttribute("automobiliDisponibili", autom); 
	    	    
		RequestDispatcher rd = req.getRequestDispatcher("le-nostre-auto.jsp");
		rd.forward(req, resp);
	}


}