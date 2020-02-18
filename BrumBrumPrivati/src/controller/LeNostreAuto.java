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
		//System.out.println("sono servlet nostre auto");
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		AutomobileDao uDao = factory.getAutomobileDao();
		String autoDaCercare=req.getParameter("ricerca");

	    List<Automobile> leNostreAuto= uDao.listaAutomobili();

	    
	    req.getSession().setAttribute("automobiliDisponibili", leNostreAuto); //sto passando la lista all'html
	    
		
		RequestDispatcher rd = req.getRequestDispatcher("le-nostre-auto.jsp"); //queste mi servono per  ricaricare la pagina
		rd.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		
		String autoDaCercare=req.getParameter("ricerca");
		System.out.println("servlet avviata");*/
		
		 resp.sendRedirect("index.jsp");

	}

}
