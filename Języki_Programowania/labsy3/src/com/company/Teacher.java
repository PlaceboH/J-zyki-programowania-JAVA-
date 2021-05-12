package com.company;

public class Teacher extends Human {
    private STAN stan = STAN.TEACHER;

    public STAN getStan() {
        return stan;
    }
    Teacher(Teacher teacher){
        setFirstName(teacher.getFirstName());
        setLastName(teacher.getLastName());
        this.stan = teacher.stan;
    }
}
