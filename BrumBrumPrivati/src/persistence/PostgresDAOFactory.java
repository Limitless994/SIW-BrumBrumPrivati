package persistence;

import persistence.FeedbackDaoJDBC;
import persistenceDao.AutomobileDao;
import persistenceDao.FeedbackDao;
import persistenceDao.UtenteDao;
import persistenceDao.OrdineDao;
import persistenceDao.PagamentoDao;
import persistenceDao.SpedizioneDao;


public class PostgresDAOFactory extends DAOFactory {

	private static DataSource dataSource;
	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource = new DataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "Web97");
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}


	@Override
	public FeedbackDao getFeedbackDAO() {
		return new FeedbackDaoJDBC(dataSource) ;
	}

	@Override
	public AutomobileDao getAutomobileDao() {
		return new AutomobileDaoJDBC(dataSource) ;
	}

	@Override
	public UtenteDao getUtenteDao() {
		return new UtenteDaoJDBC(dataSource) ;
	}

	@Override
	public OrdineDao getOrdineDAO() {
		return new OrdineDaoJDBC(dataSource) ;
	}

	@Override
	public PagamentoDao getPagamentoDAO() {
		return new PagamentoDaoJDBC(dataSource) ;
	}

	@Override
	public SpedizioneDao getSpedizioneDAO() {
		return new SpedizioneDaoJDBC(dataSource) ;
	}

}
