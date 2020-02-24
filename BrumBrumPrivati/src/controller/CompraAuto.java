package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Automobile;
import persistence.DAOFactory;
import persistenceDao.AutomobileDao;


public class CompraAuto extends HttpServlet {

	private String targaAuto=null;


	public String getTargaAuto() {
		return targaAuto;
	}

	public void setTargaAuto(String targaAuto) {
		this.targaAuto = targaAuto;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		AutomobileDao autoDao = factory.getAutomobileDao();

		String targa=targaAuto,indirizzo="Via Speronari, 8, 20123 Milano MI",modalitaSpedizione="ritiro in sede",sede="Via Speronari 32, Milano",metodoPagamento=null,iban=null,fileAffidabilita=null;

		String email=req.getParameter("email");
		metodoPagamento = req.getParameter("pagamento");
		iban = req.getParameter("iban");
		fileAffidabilita = req.getParameter("immagine");
		String nome= req.getParameter("nome")+" ";
		String cognome= req.getParameter("cognome");
		modalitaSpedizione=req.getParameter("spedizione");
		sede=req.getParameter("selezionesede");

		if(modalitaSpedizione.equals("others")) {
			if(sede.equals("roma")) {
				indirizzo="Via Sant'Agnese 12,  Roma";
			}else {
				indirizzo="Via Alessandro Volta 132, Rende, CS";
			}
		}
		Automobile automobile=autoDao.find(targa);

		req.getSession().setAttribute("nome", nome);
		req.getSession().setAttribute("cognome", cognome);
		req.getSession().setAttribute("indirizzo", indirizzo);
		req.getSession().setAttribute("email", email);
		req.getSession().setAttribute("metodoPagamento", metodoPagamento);
		req.getSession().setAttribute("iban", iban);
		req.getSession().setAttribute("sede", sede);
		req.getSession().setAttribute("AutomobileAcquistata", automobile); 
		req.getSession().setAttribute("azione", "acquisto");
		
		resp.sendRedirect("riepilogoOrdine.jsp");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		targaAuto=req.getParameter("targa");

		RequestDispatcher rd = req.getRequestDispatcher("CompraAuto.jsp"); 
		rd.forward(req, resp);
	}
}