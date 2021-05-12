package com.company;

public class Client {
    private String firstName;
    private String secondName;
    private int age;

    public Client(String fN, String sN, int age){
        firstName = fN;
        secondName = sN;
        this.age = age;
    }

    public Client(){
        firstName = "Nan";
        secondName = " NAn";
        age = 0;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

}
