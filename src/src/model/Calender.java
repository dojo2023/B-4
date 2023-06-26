package model;

import java.io.Serializable;

public class Calender implements Serializable {
	private String parts;
	private String created_date;
	private String created_time;

	public Calender(String parts, String created_date, String created_time) {
		super();
		this.parts = parts;
		this.created_date = created_date;
		this.created_time = created_time;

	}
	
	public Calender () {
		super();
		this.parts = "";
		this.created_date = "";
		this.created_time = "";
	}

	public String getWeight() {
		return parts;
	}

	public void setWeight(String parts) {
		this.parts = parts;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	
	

}