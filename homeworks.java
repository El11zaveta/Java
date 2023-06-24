package ru.safronova.api.homeWork;

import java.util.Scanner;

public class homeworks {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean f = true;
        while (f) {
            System.out.println("_________________________________");
            System.out.println("Type the exercise number: ");
            System.out.println("1 - Ex.1");
            System.out.println("2 - Ex.2");
            System.out.println("3 - Ex.3");
            System.out.println("4 - Ex.4");
            System.out.println("0 - Exit");
            System.out.println("__________________________________");
            int num = Integer.parseInt(scanner.nextLine());

            switch (num) {
                case 0:
                    System.out.println("Finishing the job.");
                    f = false;
                    break;

                case 1:
                    ex1();
                    break;

                case 2:
                    ex2();
                    break;

                case 3:
                ex3();
                    break;

                case 4:
                ex4();
                    break;

                default:
                    System.out.println("Incorrect.\nRepeat the entry.");
                    break;

            }
        }
    }

    // Ex.1 Вычислить n-ое треугольного число (сумма чисел от 1 до n), n!
    // (произведение чисел от 1 до n)

    static void ex1() {

        System.out.print("Type you number: ");

        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        int sum = 0;
        int f = 1;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
            f = f * i;
        }
        System.out.printf("The sum of %d is %d%n\nthe factorial of %d is %d\n", n, sum, n, f);
    }



    // Вывести все простые числа от 1 до 1000

    static void ex2(){
        
        for(int i = 2; i <= 1000; i ++){
            boolean Prime = true;

            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    Prime = false;
                    break;
                }
            }

            if(Prime){
                System.out.println(i);
            }
        }
    }

// Реализовать простой калькулятор

    static void ex3(){
        double num1;
        double num2;
        double ans;
        char op;
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        
        num1 = reader.nextDouble();
        num2 = reader.nextDouble();
        System.out.print("\nEnter an operator (+, -, *, /): ");
        
        op = reader.next().charAt(0);
        switch(op) {
            case '+': ans = num1 + num2;
            break;
            case '-': ans = num1 - num2;
            break;
            case '*': ans = num1 * num2;
            break;
            case '/': ans = num1 / num2;
            break;
            default:  System.out.printf("Error! Enter correct operator");
            return;
        }
        System.out.print("\nThe result is given as follows:\n");
        System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);
    }



    //Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 
    //2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно 
    //решение или сообщить, что его нет.

static void ex4(){
    System.out.println("Не решено");
}




}










