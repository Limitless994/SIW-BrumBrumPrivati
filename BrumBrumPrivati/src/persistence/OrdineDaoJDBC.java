package persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import exception.PersistenceException;
import model.Automobile;
import model.ComplexAutomobile;
import model.DettagliRiepilogo;
import model.Feedback;
import model.Ordine;
import persistenceDao.OrdineDao;


public class OrdineDaoJDBC implements OrdineDao{

	private DataSource dataSource;

	public OrdineDaoJDBC(DataSource dataSource) {

		this.dataSource = dataSource;
	}
	@Override
	public void save(Ordine ordine) {
		Connection connection = this.dataSource.getConnection();
		try {

			String insert = "insert into ordine(id,indirizzo,stato) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, ordine.getId());
			statement.setString(2, ordine.getIndirizzo());
			statement.setString(3,  ordine.getStato());
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
	public void update(Ordine ordine) {


		Connection connection = this.dataSource.getConnection();


		try {
			String update ="UPDATE ordine SET indirizzo=?, stato=? WHERE id=?";
			PreparedStatement pstmt = connection.prepareStatement(update);

			pstmt.setString(1,ordine.getIndirizzo());
			pstmt.setString(2,ordine.getStato());
			pstmt.setString(3,ordine.getId());


			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}


	}


	@Override
	public void delete(String id_ordine) {

		String sql = "DELETE FROM ordine WHERE id = ?";
		Connection connection = this.dataSource.getConnection();


		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,id_ordine);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}



	}
	@Override
	public int getLastOrder() {
		Connection connection = this.dataSource.getConnection();		
		int out=0;
		try 
		{
			PreparedStatement statement;
			String query = "select id FROM ordine WHERE cast(id as int)=(select Max(cast(id as int)) as massimo from ordine)";
			statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			if (result.next()){
				out =Integer.parseInt(result.getString("id"));
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
	@Override
	public void ordine_contiene_auto(Automobile automobile, Ordine ordine) {
		Connection connection= this.dataSource.getConnection();

		try {
			String save = "insert into contiene(automobile_targa, ordine_id) values (?,?) ";
			PreparedStatement statement = connection.prepareStatement(save);
			statement.setString(1, automobile.getTarga());
			statement.setString(2, ordine.getId());
			statement.executeUpdate();
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
	public void ordine_effettuato_da_utente(String email,Automobile automobile, Ordine ordine) {
		Connection connection= this.dataSource.getConnection();
		long millis=System.currentTimeMillis(); 
		//long millis=1563435694000L; //data 14 gennaio 2020

		java.sql.Date data=new java.sql.Date(millis);
		try {
			String save = "insert into effettua(data,ordine_id, utente_email, automobile_targa) values (?,?,?,?) ";
			PreparedStatement statement = connection.prepareStatement(save);
			statement.setDate(1, data);
			statement.setString(2, ordine.getId());
			statement.setString(3, email);
			statement.setString(4, automobile.getTarga());

			statement.executeUpdate();
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
	public List<ComplexAutomobile> storicoOrdini(String email) {
		Connection connection = this.dataSource.getConnection();		
		List<ComplexAutomobile> out = new LinkedList<>();
		ComplexAutomobile auto=null;
		System.out.println("Sto cercando le auto per "+email);
		try 
		{

			PreparedStatement statement;
			String query = "select automobile.*, effettua.ordine_id, effettua.data FROM effettua INNER JOIN automobile ON effettua.automobile_targa=automobile.targa WHERE utente_email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				auto = new ComplexAutomobile(result.getString("targa"), result.getString("marca"), result.getString("modello"), result.getString("categoria"), result.getString("colore"), result.getString("km"), result.getString("alimentazione"), result.getString("cambio"), result.getString("immagine"), result.getString("prezzovendita"), result.getString("prezzonoleggio"), result.getString("disponibilita"),result.getString("data"),result.getString("ordine_id"));			
				out.add(auto);
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

	@Override
	public void ordine_relativo_a_feedback(Feedback f, String o) {
		Connection connection= this.dataSource.getConnection();
		try {
			String save = "insert into relativo(feedback_id, ordine_id) values (?,?) ";
			PreparedStatement statement = connection.prepareStatement(save);
			statement.setString(1, f.getId());
			statement.setString(2, o);
			statement.executeUpdate();
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
	public String getIDbyTarga(String targa) {
		Connection connection= this.dataSource.getConnection();
		try {
			String out=null;
			String query = "select ordine_id from contiene where automobile_targa = ? ";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, targa);
			ResultSet result = statement.executeQuery();

			if (result.next()){
				out =result.getString("ordine_id");
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
	@Override
	public List<ComplexAutomobile> listaAutoAcquistate() {
		Connection connection = this.dataSource.getConnection();		
		List<ComplexAutomobile> out = new LinkedList<>();
		ComplexAutomobile auto=null;
		try 
		{

			PreparedStatement statement;
			String query = "select automobile.*, effettua.data,effettua.ordine_id FROM effettua INNER JOIN automobile ON effettua.automobile_targa=automobile.targa WHERE disponibilita = 'VENDUTA'";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				auto = new ComplexAutomobile(result.getString("targa"), result.getString("marca"), result.getString("modello"), result.getString("categoria"), result.getString("colore"), result.getString("km"), result.getString("alimentazione"), result.getString("cambio"), result.getString("immagine"), result.getString("prezzovendita"), result.getString("prezzonoleggio"), result.getString("disponibilita"),result.getString("data"),result.getString("ordine_id"));			
				out.add(auto);
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
	@Override
	public List<ComplexAutomobile> listaAutoNoleggiate() {
		Connection connection = this.dataSource.getConnection();		
		List<ComplexAutomobile> out = new LinkedList<>();
		ComplexAutomobile auto=null;
		try 
		{

			PreparedStatement statement;
			String query = "select automobile.*,effettua.ordine_id, effettua.data FROM effettua INNER JOIN automobile ON effettua.automobile_targa=automobile.targa WHERE disponibilita = 'NOLEGGIATA'";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				auto = new ComplexAutomobile(result.getString("targa"), result.getString("marca"), result.getString("modello"), result.getString("categoria"), result.getString("colore"), result.getString("km"), result.getString("alimentazione"), result.getString("cambio"), result.getString("immagine"), result.getString("prezzovendita"), result.getString("prezzonoleggio"), result.getString("disponibilita"),result.getString("data"),result.getString("ordine_id"));			
				out.add(auto);
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
	@Override
	public DettagliRiepilogo riepilogo(String targa) {
		Connection connection = this.dataSource.getConnection();		
		DettagliRiepilogo out = null;
		try 
		{

			PreparedStatement statement = null;
			String query = "select automobile.*, utente.*, spedizione.indirizzo,pagamento.metodo\r\n" + 
					"FROM effettua\r\n" + 
					"INNER JOIN automobile ON effettua.automobile_targa=automobile.targa \r\n" + 
					"INNER JOIN utente ON effettua.utente_email=utente.email \r\n" + 
					"INNER JOIN spedizione ON effettua.ordine_id=spedizione.id_spedizione\r\n" + 
					"INNER JOIN pagamento ON effettua.ordine_id=pagamento.id_pagamento\r\n" + 
					"WHERE automobile.targa = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, targa);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
			out = new DettagliRiepilogo(result.getString("targa"), result.getString("marca"), result.getString("modello"), result.getString("categoria"), result.getString("colore"), result.getString("km"), result.getString("alimentazione"), result.getString("cambio"), result.getString("immagine"), result.getString("prezzovendita"), result.getString("prezzonoleggio"), result.getString("nome"),result.getString("cognome"),result.getString("indirizzo"),result.getString("metodo"),result.getString("email"));			
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