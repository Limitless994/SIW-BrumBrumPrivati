package persistence;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import exception.PersistenceException;
import javafx.util.Pair;
import model.Automobile;
import model.ComplexFeedback;
import model.Feedback;
import persistenceDao.FeedbackDao;


public class FeedbackDaoJDBC implements FeedbackDao{

	private DataSource dataSource;

	public FeedbackDaoJDBC(DataSource dataSource) {

		this.dataSource = dataSource;
	}
	@Override
	public void save(Feedback feedback) {
		Connection connection = this.dataSource.getConnection();
		long millis=System.currentTimeMillis();  
		java.sql.Date data=new java.sql.Date(millis);
		try {

			String insert = "insert into Feedback(id,commento,data) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, feedback.getId());
			statement.setString(2, feedback.getCommento());
			statement.setDate(3, data);

			statement.executeUpdate();


		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}		
	}


	@Override
	public void update(Feedback feedback) {
		Connection connection = this.dataSource.getConnection();

		try {
			String update ="UPDATE feedback SET commento=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(3, feedback.getId());
			statement.setString(1, feedback.getCommento());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id_feedBack) {
		String sql = "DELETE FROM feedback WHERE id = ?";
		Connection connection = this.dataSource.getConnection();

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,id_feedBack);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	@Override
	public List<ComplexFeedback> getFeedbackByModel(String modello) {
		Connection connection = this.dataSource.getConnection();		
		List<ComplexFeedback> out = new ArrayList<ComplexFeedback>();
		try 
		{
			PreparedStatement statement;
			String sql ="SELECT feedback.id, feedback.commento, feedback.data,utente.username\r\n" + 
					"FROM feedback\r\n" + 
					"INNER JOIN rilasciato ON feedback.id = rilasciato.feedback_id\r\n" + 
					"INNER JOIN valutata on feedback.id=valutata.feedback_id\r\n" + 
					"INNER JOIN automobile on automobile.targa=valutata.automobile_id\r\n" + 
					"INNER JOIN utente on rilasciato.utente_email=utente.email\r\n" + 
					"where automobile.modello= ? ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, modello);
			ResultSet result = statement.executeQuery();
			ComplexFeedback cf;
			while (result.next()) {
				cf=new ComplexFeedback(result.getString("id"),result.getString("commento"), result.getString("username"), result.getString("data"));

				out.add(cf);
			}

			return out;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}
	public boolean giaEsistente(String targa,String email) {
		Connection connection = this.dataSource.getConnection();
		int cont=0;
		try {
			PreparedStatement statement;
			String query ="SELECT automobile.targa, utente.email\r\n" + 
					"FROM feedback \r\n" + 
					"INNER JOIN rilasciato ON feedback.id = rilasciato.feedback_id \r\n" + 
					"INNER JOIN valutata ON feedback.id=valutata.feedback_id \r\n" + 
					"INNER JOIN automobile ON automobile.targa=valutata.automobile_id \r\n" + 
					"INNER JOIN utente ON rilasciato.utente_email=utente.email \r\n" + 
					"where automobile.targa = ? and utente.email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, targa);
			statement.setString(2, email);
			ResultSet result = statement.executeQuery();


			if (result.next()) {
				cont++;

			}
			if(cont==0)return false;
			return true;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}
	@Override
	public List<ComplexFeedback> getAllFeedback() {
		Connection connection = this.dataSource.getConnection();		
		List<ComplexFeedback> out = new ArrayList<ComplexFeedback>();
		try 
		{
			PreparedStatement statement;
			String sql ="SELECT feedback.id, feedback.commento, feedback.data,utente.username\r\n" + 
					"FROM feedback\r\n" + 
					"INNER JOIN rilasciato ON feedback.id = rilasciato.feedback_id\r\n" + 
					"INNER JOIN valutata on feedback.id=valutata.feedback_id\r\n" + 
					"INNER JOIN automobile on automobile.targa=valutata.automobile_id\r\n" + 
					"INNER JOIN utente on rilasciato.utente_email=utente.email";
			statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ComplexFeedback cf;
			while (result.next()) {
				cf=new ComplexFeedback(result.getString("id"),result.getString("commento"), result.getString("username"), result.getString("data"));
				out.add(cf);
			}

			return out;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
}