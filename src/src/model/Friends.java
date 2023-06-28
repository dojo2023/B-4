package model;

import java.io.Serializable;

public class Friends implements Serializable {
	private String user_id;
	private String name;
	private String friends_id;

	public Friends(String user_id, String name, String friends_id) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.friends_id = friends_id;
	}

	public Friends () {
		super();
		this.user_id = "";
		this.name = "";
		this.friends_id = "";
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFriends_id() {
		return friends_id;
	}
	public void setFriends_id(String friends_id) {
		this.friends_id = friends_id;
	}


}
