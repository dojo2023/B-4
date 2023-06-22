package model;
import java. io. Serializable;
public class Charas implements Serializable {

  private String id;
  private String chara_id;
  private String chara_file;


public Charas (String id, String chara_id, String chara_file) {
	super ();
	this.id = id;
	this.chara_id = chara_id;
	this.chara_file = chara_file;
}

public Charas () {
	super ();
	this.id = "";
	this.chara_id = "";
	this.chara_file = "";
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
public String getChara_file() {
	return chara_file;
}
public void setChara_file(String chara_file) {
	this.chara_file = chara_file;
}

}

