package main.java.by.bsuir.pms413802.Chayevskiy.entities;

public class User {
    protected int id;
    protected String name;
    protected String surname;

    public User(){}

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname){
        this(name, surname);
        this.id = id;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
