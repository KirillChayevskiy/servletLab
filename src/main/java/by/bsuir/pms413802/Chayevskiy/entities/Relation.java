package main.java.by.bsuir.pms413802.Chayevskiy.entities;

public class Relation {
    protected int id;
    protected int userID;
    protected int tariffID;

    public Relation(){}

    public Relation(int id) {
        this.id = id;
    }

    public Relation(int id, int userID, int tariffID){
        this(userID, tariffID);
        this.id = id;
    }

    public Relation(int userID, int tariffID) {
        this.userID = userID;
        this.tariffID = tariffID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTariffID() {
        return tariffID;
    }

    public void setTariffID(int tariffID) {
        this.tariffID = tariffID;
    }
}
