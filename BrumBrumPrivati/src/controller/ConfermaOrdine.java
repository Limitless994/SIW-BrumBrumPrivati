package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		OrdineDao ordine=factory.getOrdineDAO();
		AutomobileDao autoDao = factory.getAutomobileDao();
		PagamentoDao pagamento = factory.getPagamentoDAO();
		SpedizioneDao spedizione=factory.getSpedizioneDAO();
		String loggedUser=null,indirizzo="Via Speronari, 8, 20123 Milano MI",modalitaSpedizione="ritiro in sede",sede=null,metodoPagamento=null,iban=null,fileAffidabilita=null;

		int lastOrderID=ordine.getLastOrder();
		lastOrderID+=1;
		String nextOrderID = Integer.toString(lastOrderID); 

		sede =(String) req.getSession().getAttribute("spedizione");
		metodoPagamento = (String) req.getSession().getAttribute("metodoPagamento");
		iban = (String) req.getSession().getAttribute("iban");
		loggedUser=(String) req.getSession().getAttribute("email");
		Automobile automobileVenduta=(Automobile) req.getSession().getAttribute("AutomobileAcquistata");

		Ordine newOrdine= new Ordine(nextOrderID,indirizzo,"ordine ricevuto");
		Pagamento newPagamento=new Pagamento(nextOrderID, metodoPagamento, nextOrderID, Integer.parseInt(automobileVenduta.getPrezzovendita()));	
		Spedizione newSpedizione=new Spedizione(nextOrderID, indirizzo, modalitaSpedizione, nextOrderID);
		
		if(req.getSession().getAttribute("azione").equals("acquisto"))automobileVenduta.setDisponibilita("VENDUTA");
		else automobileVenduta.setDisponibilita("NOLEGGIATA");
		
		ordine.save(newOrdine);
		pagamento.save(newPagamento);
		spedizione.save(newSpedizione);
		
		autoDao.update(automobileVenduta);
		
		ordine.ordine_contiene_auto(automobileVenduta, newOrdine);
		ordine.ordine_effettuato_da_utente(loggedUser, automobileVenduta, newOrdine);

		
		//		send_mail_gmail.sendEmail(loggedUser);

		resp.sendRedirect("index.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("riepilogoOrdine.jsp");
	}


}