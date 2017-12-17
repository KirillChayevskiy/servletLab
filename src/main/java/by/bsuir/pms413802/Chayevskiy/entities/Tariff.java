package main.java.by.bsuir.pms413802.Chayevskiy.entities;

public class Tariff {
    protected int id;
    protected String name;


    public Tariff(){}

    public Tariff(int id) {
        this.id = id;
    }

    public Tariff(int id, String name){
        this(name);
        this.id = id;
    }

    public Tariff(String name) {
        this.name = name;
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

}
