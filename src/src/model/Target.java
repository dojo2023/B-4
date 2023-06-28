package model;

import java.io.Serializable;


public class Target implements Serializable {
	private String user_id;
	private int target;
	private String date;

	public Target() {
		this.user_id = "";
		this.target = 0;
		this.date = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}




}