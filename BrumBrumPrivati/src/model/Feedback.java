package model;

import java.sql.Date;

public class Feedback {
	private String id;
	private String commento; 
	private String date; 
	
	public String getCommento() {
		return commento;
	}
	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", commento=" + commento + ", date=" + date + "]";
	}
	public Feedback(String id, String commento, String string) {
		super();
		this.id = id;
		this.commento = commento;
		this.date = string;
	}

	
}
