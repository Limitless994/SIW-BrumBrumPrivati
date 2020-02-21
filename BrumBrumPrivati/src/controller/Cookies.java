package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import model.Utente;
import persistence.DAOFactory;
import persistenceDao.UtenteDao;

public class Cookies extends HttpServlet{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
			UtenteDao uDao = factory.getUtenteDao();
			

			String jsonReceived = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String line = reader.readLine();
			while (line != null) {
				jsonReceived = jsonReceived + line + "\n";
				line = reader.readLine();
			}
//			System.out.println(jsonReceived);
			String p= jsonReceived.replace("\n", "");
			
			try {
				String email=req.getParameter("email");
				Utente u=uDao.find(email);
//				System.out.println(u.toString());
				req.getSession().setAttribute("utente", u);
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			doGet(req, resp);
		}
	}
