package model;


import java.io.Serializable;

public class Trainings implements Serializable {
	private String user_id;
	private String id;
	private String parts_name;
	private String created_at;
	private String updated_at;
	public Trainings(String user_id,String parts_name) {
		super();
		this.user_id = user_id;
		this.parts_name = parts_name;
	}

	public Trainings(String user_id, String id, String parts_name, String created_at, String updated_at) {
		super();
		this.user_id = user_id;
		this.id = id;
		this.parts_name = parts_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Trainings () {
		super();
		this.user_id = "";
		this.id = "";
		this.parts_name = "";
		this.created_at = "";
		this.updated_at = "";
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
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

}


