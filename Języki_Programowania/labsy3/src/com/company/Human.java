package com.company;

import java.util.LinkedList;

class Human {
    private String firstName;
    private String lastName;
    enum STAN{TEACHER, STUDENT}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    Human(){
        firstName = " ";
        lastName = " ";
    }

    Human(String name, String lname){
        firstName = name;
        lastName = lname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
