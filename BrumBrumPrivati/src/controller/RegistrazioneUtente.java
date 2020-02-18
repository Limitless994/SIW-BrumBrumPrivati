package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utente;
import persistence.DAOFactory;
import persistenceDao.UtenteDao;


public class RegistrazioneUtente extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		String nome=null, cognome=null,  codice_fiscale=null, username=null, password=null, email=null;
		if(!req.getParameter("nome").isEmpty() && !req.getParameter("cognome").isEmpty() && !req.getParameter("codice_fiscale").isEmpty() && !req.getParameter("username").isEmpty() && !req.getParameter("password").isEmpty() && !req.getParameter("email").isEmpty())
		{ 
			nome=req.getParameter("nome");
			cognome=req.getParameter("cognome");
			codice_fiscale=req.getParameter("codice_fiscale");
			username=req.getParameter("username");
			password=req.getParameter("password");
			email=req.getParameter("email");
		}

		String tipo="privato";

		String partita_iva =null;

		Utente u= new Utente(username, password, email, tipo, codice_fiscale, partita_iva, nome, cognome);
		UtenteDao utenteDao = factory.getUtenteDao();
		utenteDao.save(u);
		resp.sendRedirect("index.jsp");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("RegForm.html");

	}

}
