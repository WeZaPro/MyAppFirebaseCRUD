package com.example.myappfirebasecrud;

public class MyModelData {
    String UID;
    String name;
    String number;

    public MyModelData() {
    }

    public MyModelData(String UID,String number, String name) {
        this.UID = UID;
        this.name = name;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
