package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComplexAutomobile;
import model.DettagliRiepilogo;
import persistence.DAOFactory;
import persistenceDao.OrdineDao;

public class VisualizzaDettagliOrdine extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		OrdineDao o=factory.getOrdineDAO();
		
		String targa= req.getParameter("automobile");
		DettagliRiepilogo DR=o.riepilogo(targa);
		req.getSession().setAttribute("DR", DR);
		resp.sendRedirect("riepilogoOrdineAdmin.jsp");
	}
}

