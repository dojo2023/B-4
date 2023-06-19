package model;

import java.io.Serializable;

public class Registdata implements Serializable{
    private String id;
    private String password;
    private String repass;

public Registdata(String id, String password, String repass) {
	super();

	this.id = id;
	this.password = password;
	this.repass = repass;
	}
public Registdata() {
	super();
	this.id = "";
	this.password = "";
	this. repass= "";
    }

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getRepass() {
	return repass;
}

public void setRepass(String repass) {
	this.repass = repass;
}

}