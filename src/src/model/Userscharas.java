package model;
import java. io. Serializable;
public class Userscharas implements Serializable {

  private String id;
  private String user_id;
  private String chara_id;

public Userscharas (String id, String user_id, String chara_id) {
	super ();
	this.id = id;
	this.user_id = user_id;
	this.chara_id = chara_id;
}

public Userscharas () {
	super ();
	this.id = "";
	this.user_id = "";
	this.chara_id = "";
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public String getChara_id() {
	return chara_id;
}

public void setChara_id(String chara_id) {
	this.chara_id = chara_id;
}
}