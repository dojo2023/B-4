package model;

import java.io.Serializable;


public class FrinedList implements Serializable {
	private String user_id;
	private String friend_id;
	private String user_name;
	
	
	public FrinedList(String user_id, String friend_id, String user_name) {
		super();
		this.user_id = user_id;
		this.friend_id = friend_id;
		this.user_name = user_name;
	}
	
	public FrinedList () {
		super();
		this.user_id = "";
		this.friend_id = "";
		this.user_name = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(String friend_id) {
		this.friend_id = friend_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
}
