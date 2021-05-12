package com.company;

import java.util.LinkedList;

public class Pwr {

    private LinkedList<Subject> subjects  = new LinkedList();
    private LinkedList<Student> allStudents = new LinkedList<>();
    private LinkedList<Teacher> allTeacher = new LinkedList<>();


    public void addTeacher(Teacher teacher){
        allTeacher.addLast(teacher);
    }

    public void addStudent(Student student){
        allStudents.addLast(student);
    }

    public void addSubject(Subject subject){
        subjects.addLast(subject);
    }

    public void deleteSubject(Subject subject){
        for(Subject i : subjects){
            if(i.getName() == subject.getName()){
                subjects.remove(i);
            }
        }
    }

    public LinkedList<Subject> getSubjects() {
        return subjects;
    }

    public LinkedList<Student> getAllStudents() {
        return allStudents;
    }

    public LinkedList<Teacher> getAllTeacher() {
        return allTeacher;
    }
}
