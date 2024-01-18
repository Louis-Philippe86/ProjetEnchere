package fr.labo.testing;

import java.io.IOException;

import fr.labo.bll.UtilisateurManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jdbcTest
 */
@WebServlet("/jdbcTest")
public class jdbcTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public jdbcTest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilisateurManager manager = new UtilisateurManager();

		//Adresse adresse = new Adresse("rue","nantes","4000");

		//Utilisateur user = new Utilisateur("awl213", "herciu22", "alin22","coolemail@gw2il.com","1234567890",adresse, 10, false,"s2tronPasswor2d");

		//manager.ajouterUser(user);
		//manager.deleteUser(10);
		
		System.out.println(manager.verifierPseudoEtEmail("awl213", "coolemail@gw2il.com"));
		System.out.println(manager.verifierPseudoEtPassword("awl213", "s2tronPasswor2d"));
		System.out.println(manager.getUser(11));
		//System.out.println(manager.getAll()+" useres in the db");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
