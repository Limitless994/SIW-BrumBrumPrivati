package persistenceDao;


import java.util.List;

import javafx.util.Pair;
import model.ComplexAutomobile;
import model.ComplexFeedback;
import model.Feedback;

public interface FeedbackDao 
{
	public void save(Feedback feedback); // Create

	public void update(Feedback feedback); // Update

	public void delete(String feedback); // Delete
	
	public List<ComplexFeedback> getFeedbackByModel(String model);
	
	public boolean giaEsistente(String model, String email);

	public List<ComplexFeedback> getAllFeedback();


}
