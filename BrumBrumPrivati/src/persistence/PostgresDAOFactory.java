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
			dataSource = new DataSource("jdbc:postgresql://ec2-54-246-89-234.eu-west-1.compute.amazonaws.com:5432/d7pcnb70a32rfr?sslmode=require", "vybdautkffijbv", "60ca5fbcbe1f64464952402f37cdf1b8c8467c81e1fc3a97394621253ebcc1f5");
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
