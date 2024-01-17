package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import fr.labo.bo.User;

@WebServlet("/ServletConnectionUser")
public class ServletConnectionUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connectionUser.jsp");
		rd.forward(request, response);
    
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Créaetion d'un liste d'utilisateur pour test
		User user1 = new User("a","a");
		User user2 = new User("b","b");
		
		List<User> listeUser = new ArrayList<User>();
		listeUser.add(user1);
		listeUser.add(user2);

		// Récupération des identifiants et mot de passe de l'utilisateur
		String idUser = request.getParameter("idUser");
		String passwordUser = request.getParameter("passwordUser");
		User utilisateurExistant = null;
		HttpSession session =  request.getSession(false);
		
		//--------------------A modifier----------------------------//

	
		//A modifier avec condition : si useur existe
		for (User user : listeUser) {
			
			if(idUser.equals(user.getIdUser()) && passwordUser.equals(user.getPasswordUser())) {
				
				utilisateurExistant = user;
				
				
			}
		}
		if(utilisateurExistant != null) {
				session =  request.getSession(true);
				session.setAttribute("user", utilisateurExistant);
				response.sendRedirect("ServletAccesIndexJsp");
				
		}else {
			
			request.setAttribute("erreur", "l'utilisateur ou mot de passe n'est pas valide");
			doGet(request, response);
			
		}
		
		
		
		//Si useur n'existe pas
		
		
		//----------------------------------------------------------//
		
		
		
		
	}
}

