package model;

import java.io.Serializable;


public class Weight implements Serializable {
	private int user_id;
	private int weight;
	private String date;

	public Weight() {
		this.user_id = 0;
		this.weight = 0;
		this.date = "";
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}