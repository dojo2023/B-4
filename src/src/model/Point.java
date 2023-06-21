package model;
import java.io.Serializable;

public class Point implements Serializable{
    private String user_id;
    private int points;

    public Point(String user_id, int points) {
        this.user_id = user_id;
        this.points = points;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
