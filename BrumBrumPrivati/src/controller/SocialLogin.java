package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import persistence.DatabaseManager;
import persistenceDao.UtenteDao;

public class SocialLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		HttpSession session = request.getSession();

		// log-out
		session.removeAttribute("username");
		session.removeAttribute("loggato");
		session.removeAttribute("utente");
		session.removeAttribute("tipo");
		session.removeAttribute("email");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		RequestDispatcher rd;

		Utente loggedUser = (Utente) session.getAttribute("utente");

		if (loggedUser == null) {

			String email = req.getParameter("email");
			String nome = req.getParameter("nome");
			String cognome = req.getParameter("cognome");
			String password = "123";

			UtenteDao dao = DatabaseManager.getInstance().getDaoFactory().getUtenteDao();
			loggedUser = dao.find(email);


			if (loggedUser == null) {
				loggedUser = new Utente("facebookUser", password, email, "privato", "XXXXXX99X33X000X", "0", nome, cognome);
				dao.save(loggedUser);
			}
			System.out.println(loggedUser);
			req.getSession().setAttribute("email", email);
			req.getSession().setAttribute("nome", nome);
			req.getSession().setAttribute("cognome", cognome);
			req.getSession().setAttribute("utente", loggedUser);


		}
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);

	}

}