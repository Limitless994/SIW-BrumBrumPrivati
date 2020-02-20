package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.send_mail_gmail;
import model.Automobile;
import model.Ordine;
import model.Pagamento;
import model.Spedizione;
import persistence.DAOFactory;
import persistenceDao.AutomobileDao;
import persistenceDao.OrdineDao;
import persistenceDao.PagamentoDao;
import persistenceDao.SpedizioneDao;

public class ConfermaOrdine  extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		boolean noleggio=(boolean) req.getSession().getAttribute("noleggio");
		List<Automobile> lAuto=(List<Automobile>) req.getSession().getAttribute("automobiliDaComprare");
		String targaAuto=(String) req.getSession().getAttribute("targa");
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		OrdineDao ordine=factory.getOrdineDAO();
		AutomobileDao autoDao = factory.getAutomobileDao();
		SpedizioneDao spedizione1= factory.getSpedizioneDAO();
		PagamentoDao pagamento = factory.getPagamentoDAO();
		String targa=targaAuto,loggedUser=null,indirizzo="Via Speronari, 8, 20123 Milano MI",modalitaSpedizione="ritiro in sede",sede=null,metodoPagamento=null,iban=null,fileAffidabilita=null;

		int lastOrderID=ordine.getLastOrder();
		lastOrderID+=1;
		String nextOrderID = Integer.toString(lastOrderID); 
		
		double totaleOrdine=(double) req.getSession().getAttribute("totaleOrdine");
		sede =(String) req.getSession().getAttribute("spedizione");
		metodoPagamento = (String) req.getSession().getAttribute("metodoPagamento");
		iban = (String) req.getSession().getAttribute("iban");
		fileAffidabilita =(String) req.getSession().getAttribute("imgAutoRiep");
		loggedUser=(String) req.getSession().getAttribute("email");

		if(modalitaSpedizione.equals("others")) {
			if(sede.equals("roma")) {
				indirizzo="Via Sant'Agnese 12,  Roma";
			}else {
				indirizzo="Via Alessandro Volta 132, Rende, CS";
			}
		}
		
		Ordine newOrdine= new Ordine(nextOrderID,indirizzo,"ordine ricevuto");
		ordine.save(newOrdine);
		
		Spedizione newSpedizione=new Spedizione(nextOrderID, indirizzo, modalitaSpedizione, nextOrderID);
		Pagamento newPagamento=new Pagamento(nextOrderID, metodoPagamento, nextOrderID, totaleOrdine);
		spedizione1.save(newSpedizione);
		pagamento.save(newPagamento);
		
		String email=(String) req.getSession().getAttribute("email");
//		send_mail_gmail.sendEmail(email);
		
		
		resp.sendRedirect("index.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("riepilogoOrdine.jsp");
	}


}
