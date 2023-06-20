package model;
import java. io. Serializable;
public class Serifus implements Serializable {

  private String id;
  private String chara_id;
  private String serif;

public Serifus (String id, String chara_id, String serif) {
	super ();
	this.id = id;
	this.chara_id = chara_id;
	this.serif = serif;
}

public Serifus () {
	super ();
	this.id = "";
	this.chara_id = "";
	this.serif = "";
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getChara_id() {
	return chara_id;
}

public void setChara_id(String chara_id) {
	this.chara_id = chara_id;
}

public String getSerif() {
	return serif;
}

public void setSerif(String serif) {
	this.serif = serif;
}
}