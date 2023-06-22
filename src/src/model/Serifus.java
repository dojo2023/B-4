package model;
import java. io. Serializable;
public class Serifus implements Serializable {

  private String chara_file;
  private String serif;

public Serifus (String chara_file, String serif) {
	super ();

	this.chara_file = chara_file;
	this.serif = serif;
}
public Serifus() {
	super();
	this.chara_file = "";
	this.serif = "";
}

public String getChara_file() {
	return chara_file;
}

public void setChara_file(String chara_file) {
	this.chara_file = chara_file;
}

public String getSerif() {
	return serif;
}

public void setSerif(String serif) {
	this.serif = serif;
}



}