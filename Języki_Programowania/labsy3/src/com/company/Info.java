package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Info {

    public void infoStudents(Pwr pwr) throws FileNotFoundException {
        PrintWriter print = new PrintWriter("s.txt");
        LinkedList<Student> s = pwr.getAllStudents();
        for(Student i : s){
            print.println(i.getFirstName() + " " + i.getLastName() );
        }


    }

    public void infoTeacher(Pwr pwr) throws FileNotFoundException {
        PrintWriter print = new PrintWriter("t.txt");
        LinkedList<Teacher> t = pwr.getAllTeacher();
        for(Teacher i : t){
            print.println(i.getFirstName() + " " + i.getLastName() );
        }
    }

    public void Zajęcia(Pwr pwr) throws FileNotFoundException {
        PrintWriter print = new PrintWriter("sub.txt");
        LinkedList<Subject> sub = pwr.getSubjects();
        for(Subject i : sub){
            print.println(i.getName() + "liczba miejsc: " + i.getLiczbamiejsc());
        }
    }

}
