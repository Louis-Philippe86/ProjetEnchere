package fr.labo.dal.vente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.dal.ConnectionProvider;

public class VenteDAOJdbcImpl implements VenteDAO {

	@Override
	public void insert(ArticleVendu vente) {
		String insertArticleQuery = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial,"
				+ "prix_vente, no_utilisateur, no_categorie) VALUES("
				+ "?,?,?,?,?,?,?,?)";
		String insertRetraitQuery = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES"
				+ "(?,?,?,?)";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmtArticle = cnx.prepareStatement(insertArticleQuery,Statement.RETURN_GENERATED_KEYS);
			
			PreparedStatement pstmtRetrait = cnx.prepareStatement(insertRetraitQuery);
			
			pstmtArticle = HelperClassVente.setPreparedStatementParameters(pstmtArticle, vente);
			pstmtArticle.executeUpdate();
			
			ResultSet rs = pstmtArticle.getGeneratedKeys();
			if(rs.next()) {
				vente.setNoArticle(rs.getInt(1));
			}
			//insérer dans la table retrait après avoir obtenu id de l'article
			pstmtRetrait.setInt(1, vente.getNoArticle());
			pstmtRetrait.setString(2, vente.getRetrait().getRue());
			pstmtRetrait.setString(3, vente.getRetrait().getCodePostal());
			pstmtRetrait.setString(4, vente.getRetrait().getVille());
			pstmtRetrait.execute();
			
			
			rs.close();
			pstmtArticle.close();
			pstmtRetrait.close();
			cnx.close();
			
		} catch (SQLException e) {
			 System.out.println("Erreur d'insertion de l'ArticleVendu" + e.getMessage());
		}
		
	}

	@Override
	public List<ArticleVendu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectCategorieLibelles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
