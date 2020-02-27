package persistenceDao;

import java.util.List;

import model.Automobile;
import model.Feedback;

public interface AutomobileDao {

	public void save(Automobile automobile); // Create

	public void update(Automobile automobile); // Update

	public void delete(String automobile); // Delete
	
	public Automobile find(String id);

	public int getSellPrice(String id);
	
	public List<Automobile> cercaAuto(String autoDaCercare);

	public List<Automobile> listaAutomobili();
		
	public void auto_valutata_con(Feedback f,String a);

	void auto_aggiunta_al_carrello(String targa, String id_carrello);

	void auto_Corrisponde_Ordine(String id_auto, String id_ordine);

	public List<Automobile> cercaAutoIntera(String daCercare);


}


