package persistenceDao;

import model.Feedback;
import model.Utente;

public interface UtenteDao {

	public void save(Utente utente); // Create

	public void update(Utente utente); // Update

	public void delete(String email); // Delete
	
	public Utente find(String email);	
	
//	public Feedback findByPrimaryKey(String id); // Retrieve
	
	public void feedback_rilasciato_da(String u, Feedback f);
	
	public int getNumeroUtentiRegistrati();

}
