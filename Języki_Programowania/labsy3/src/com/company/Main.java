package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.PortUnreachableException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File students = new File("s.txt");
        File teachers = new File("t.txt");
        Scanner s = new Scanner(students);
        Scanner t = new Scanner(teachers);

    }

}
