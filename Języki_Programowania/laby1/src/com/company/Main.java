package com.company;
import java.util.Scanner;

public class Main {


    static void Rownanie() {
        System.out.println("\n ZADANIE 1: ");
        double a, b, c, d;
        double x1, x2;
        Scanner in = new Scanner(System.in);
        System.out.println("Wpisz A: ");
        a = in.nextDouble();
        System.out.println("Wpisz B: ");
        b = in.nextDouble();
        System.out.println("Wpisz C: ");
        c = in.nextDouble();
        d = Math.pow(b, 2) - (4 * a * c);

        if(a != 0) {
            if (d > 0) {
                x1 = ((-1) * b + Math.sqrt(d)) / 2 * a;
                x2 = ((-1) * b - Math.sqrt(d)) / 2 * a;
                System.out.printf("x1 = " + x1 + " x2 = " + x2);
            } else if (d == 0) {
                x1 = (-1) * b;
                System.out.printf("x1, x2 = " + x1);
            } else {
                System.out.printf("nie ma rozwiazan w zbiorze liczb rzeczywistych");

            }
        }
        else{
            System.out.printf("x = " + -c/b);
        }

    }


    static double znak(int operator, double a, double b){
        if(operator == 1){
            return  a + b;
        }
        else if(operator == 2){
            return a - b;
        }
        else if(operator == 3){
            return a*b;
        }
        else if(operator == 4){
            return a/b;
        }
        else{
            System.out.printf("nie poprawny znak");
            System.exit(0);
            return 0;
        }
    }

    static void Zad2(){
        System.out.println("\n ZADANIE 2: ");
        double a, b, c;
        int operator1, operator2;
        Scanner in = new Scanner(System.in);
        System.out.println("Wpisz znak 1: ");
        operator1 = in.nextInt();
        System.out.println("Wpisz znak 2: ");
        operator2 = in.nextInt();
        double max = 0;
        boolean first = true;
        double A = 0, B = 0, C = 0;
        for(int i = -10; i <= 10; i++){
            for(int j = - 10; j <= 10; j++){
                for(int k = -10; k <= 10; k++){
                    a = znak(operator1, i, j);
                    b = znak(operator2, a, k);
                    if(first){
                        max = b;
                        A = i;
                        B = j;
                        C = k;
                        first = false;
                    }
                    if(max < b){
                        max = b;
                        A = i;
                        B = j;
                        C = k;
                    }
                }
            }
        }
        char[] znaki = new char[4];
        znaki[0] = '+' ;
        znaki[1] = '-';
        znaki[2] = '*';
        znaki[3] = '/';

        System.out.println("(" + A + znaki[operator1-1] + B + ")" + znaki[operator2-1] + C + " = " +  max);
    }



    public static void main(String[] args) {
        Rownanie();
        //Zad2();

    }
}
