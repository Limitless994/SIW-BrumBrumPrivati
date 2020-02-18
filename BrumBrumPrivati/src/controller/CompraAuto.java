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
import model.Ordine;
import model.Pagamento;
import model.Spedizione;
import persistence.DAOFactory;
import persistenceDao.AutomobileDao;
import persistenceDao.OrdineDao;
import persistenceDao.PagamentoDao;
import persistenceDao.SpedizioneDao;

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
		boolean daCarrello=(boolean) req.getSession().getAttribute("acqCarrello");

		System.out.println("sono la bool:"+daCarrello);
		String targa=targaAuto,loggedUser=null,indirizzo="Via Speronari, 8, 20123 Milano MI",modalitaSpedizione="ritiro in sede",sede=null,metodoPagamento=null,iban=null,fileAffidabilita=null;

		List<Automobile> autoDaComprare = new ArrayList<Automobile>();
		double totaleOrdine=0;

		String email=req.getParameter("email");
		metodoPagamento = req.getParameter("pagamento");
		iban = req.getParameter("iban");
		fileAffidabilita = req.getParameter("immagine");
		loggedUser=req.getParameter("email");
		String nome= req.getParameter("nome")+" ";
		String cognome= req.getParameter("cognome");




		req.getSession().setAttribute("nome", nome);
		req.getSession().setAttribute("cognome", cognome);
		
		boolean VerificaSeSonoUnRivenditore=(boolean) req.getSession().getAttribute("SonoUnRivenditore");
		if(VerificaSeSonoUnRivenditore==false)
			req.getSession().setAttribute("indirizzo", indirizzo);
		req.getSession().setAttribute("indirizzo", indirizzo);
		req.getSession().setAttribute("email", email);
		req.getSession().setAttribute("metodoPagamento", metodoPagamento);


		req.getSession().setAttribute("iban", iban);


		if(daCarrello==false)
		{

			Automobile automobile=autoDao.find(targa);
			totaleOrdine+=Double.parseDouble(automobile.getPrezzovendita());
			
			if(VerificaSeSonoUnRivenditore==false) {
			modalitaSpedizione = req.getParameter("spedizione");
			sede = req.getParameter("selezionesede");


			if(modalitaSpedizione.equals("others")) {
				if(sede.equals("roma")) {
					indirizzo="Via Sant'Agnese 12,  Roma";
				}else {
					indirizzo="Via Alessandro Volta 132, Rende, CS";
				}
			}}


			String descrizione=automobile.getMarca()+" "+automobile.getModello()+" "+automobile.getColore();
			String imgAutoRiep=automobile.getImmagine();
			String prezzoAuto=automobile.getPrezzovendita();
			req.getSession().setAttribute("targa", targaAuto);

			req.getSession().setAttribute("spedizione", modalitaSpedizione); 

			req.getSession().setAttribute("descrizione", descrizione);
			req.getSession().setAttribute("imgAutoRiep", imgAutoRiep);  //non � una stringa!!!!!!!!!
			req.getSession().setAttribute("prezzoAuto", prezzoAuto);



			autoDaComprare.add(automobile);
			//req.getRequestDispatcher("/riepilogoOrdine.jsp").forward(req, resp);

		}
		req.getSession().setAttribute("automobiliDaComprare", autoDaComprare);
		req.getSession().setAttribute("totaleOrdine", totaleOrdine);
		
		boolean noleggio= false;
		req.getSession().setAttribute("noleggio",noleggio );

		resp.sendRedirect("riepilogoOrdine.jsp");


	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		targaAuto=req.getParameter("targa");

		RequestDispatcher rd = req.getRequestDispatcher("CompraAuto.jsp"); //queste mi servono per  ricaricare la pagina
		rd.forward(req, resp);
	}
}
