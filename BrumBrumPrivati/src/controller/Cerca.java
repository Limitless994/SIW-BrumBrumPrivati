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
		/*DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		
		String autoDaCercare=req.getParameter("ricerca");
		System.out.println("servlet avviata");*/
		
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
		System.out.println(autoDaCercare);
		
		if(autoDaCercare.length()>=1)
	    autom= uDao.cercaAuto(autoDaCercare);
	    
	    req.getSession().setAttribute("automobiliDisponibili", autom); //sto passando la lista all'html
	    
	   // resp.sendRedirect("le-nostre-auto.html");
	    
	    for(Automobile auto:autom)
	    {
	    	System.out.println("AUTO TROVATA: " + auto.getModello()+" "+auto.getTarga());
	    }
		
		
		RequestDispatcher rd = req.getRequestDispatcher("le-nostre-auto.jsp"); //queste mi servono per ricaricare la pagina
		rd.forward(req, resp);
	}


}