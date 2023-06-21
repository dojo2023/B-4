package model;


import java.io.Serializable;

public class Training implements Serializable {
	private String user_id;
	private String id;
	private String parts_name;

	public Training(String user_id, String id, String parts_name) {
		super();
		this.user_id = user_id;
		this.id = id;
		this.parts_name = parts_name;
	}

	public Training () {
		super();
		this.user_id = "";
		this.id = "";
		this.parts_name = "";
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParts_name() {
		return parts_name;
	}
	public void setParts_name(String parts_name) {
		this.parts_name = parts_name;
	}



}

