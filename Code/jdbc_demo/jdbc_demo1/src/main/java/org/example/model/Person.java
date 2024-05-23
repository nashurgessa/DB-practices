package org.example.model;

public class Person {
    private String ID;
    private String name;

    private  String mother;

    private String father;

    public Person() {
    }

    public Person(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Person(String ID, String name, String mother, String father) {
        this.ID = ID;
        this.name = name;
        this.mother = mother;
        this.father = father;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }
}
