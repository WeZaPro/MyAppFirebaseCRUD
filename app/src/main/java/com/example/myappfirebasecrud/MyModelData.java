package com.example.myappfirebasecrud;

public class MyModelData {
    String UID;
    String name;
    public MyModelData() {
    }

    public MyModelData(String UID, String name) {
        this.UID = UID;
        this.name = name;

    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
