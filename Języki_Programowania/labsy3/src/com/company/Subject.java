package com.company;

import java.util.LinkedList;

public class Subject {

    private String name;
    private Teacher teacher;
    private LinkedList<Student> students = new LinkedList();
    private int liczbamiejsc;

    public String getName() {
        return name;
    }

    public int getLiczbamiejsc() {
        return liczbamiejsc;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    Subject(){
        name = " ";
        liczbamiejsc = 0;
    }

    Subject(Teacher teacher, int wolneMiejsca){
        this.teacher = teacher;
        liczbamiejsc = wolneMiejsca;
    }


    public void addStudent(Student student, Pwr pwr){
        LinkedList<Student> s = pwr.getAllStudents();
        for( Student i : s) {
            if ((liczbamiejsc - students.size()) > 0 && student.getLastName() == i.getLastName() && student.getFirstName() == i.getFirstName()) {
                students.addLast(student);
            }
        }
    }
    public void changeTeacher(Teacher t1, Pwr pwr){
        LinkedList<Teacher> t = pwr.getAllTeacher();
        for( Teacher i : t) {
          if(i.getFirstName() == t1.getFirstName() && i.getLastName() == t1.getLastName()){
              this.teacher = i;
          }
        }
    }


    public void wypiszStudenta(Student s){
        for(Student i : students){
            if(i.getFirstName() == s.getFirstName() && i.getLastName() == s.getLastName()){
                students.remove(i);
            }
        }
    }



}
