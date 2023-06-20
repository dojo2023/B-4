package model;

import java.io.Serializable;

public class Logindata implements Serializable {
	private String user_id;	// ID
	private String user_password;	// PW

	public Logindata(String user_id, String user_password) {
		this.user_id = user_id;
		this.user_password = user_password;
	}

	public Logindata() {
		this.user_id = "";
		this.user_password = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUserpassword(String user_password) {
		this.user_password = user_password;
	}

}