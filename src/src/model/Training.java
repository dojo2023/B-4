package model;


import java.io.Serializable;

public class Training implements Serializable {
	private String user_id;
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	private String parts_name;

	public String getParts_name() {
		return parts_name;
	}

	public void setParts_name(String parts_name) {
		this.parts_name = parts_name;
	}
}
