package ru.safronova.api.homeWork;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;
import java.util.Stack;
import java.util.LinkedList;


public class homeworks {

    static Scanner scanner = new Scanner(System.in);
    private static Object lib;

    public static void main(String[] args) throws Exception {

        boolean f = true;
        while (f) {
            System.out.println("_________________________________");
            System.out.println("Type the exercise number: ");
            System.out.println("1 - Ex.1");
            System.out.println("2 - Ex.2");
            System.out.println("3 - Ex.3");
            System.out.println("4 - Ex.4");
            System.out.println("5 - Ex.5");
            System.out.println("6 - Ex.6");
            System.out.println("7 - Ex.7");
            System.out.println("8 - Ex.8");
            System.out.println("9 - Ex.9");
            System.out.println("10 - Ex.10");
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

                case 3: // добавлено удаление последней операции
                    ex3();
                    break;

                case 4:
                    ex4();
                    break;

                case 5:
                    ex5();
                    break;

                case 6:
                    ex6();
                    break;

                case 7:
                    ex7();
                    break;

                case 8:
                    ex8();
                    break;

                case 9:
                    ex9();
                    break;

                case 10:
                    ex10();
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

    static void ex2() {

        for (int i = 2; i <= 1000; i++) {
            boolean Prime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    Prime = false;
                    break;
                }
            }

            if (Prime) {
                System.out.println(i);
            }
        }
    }

    // Реализовать простой калькулятор

    static void ex3(){
   
        Logger logger = Logger.getLogger(homeworks.class.getName());

        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);

        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        String operator;

        Stack<String> operationsStack = new Stack<>(); 

        System.out.print("Введите первое число: ");
        num1 = scanner.nextDouble();
        System.out.print("Введите оператор (+, -, *, /): ");
        operator = scanner.next();
        System.out.print("Введите второе число: ");
        num2 = scanner.nextDouble();

        double result = 0.0;
        boolean isValidOperator = true;

        switch (operator) {
            case "+":
                result = num1 + num2;
                logger.log(Level.INFO, "Выполнено сложение " + num1 + " + " + num2);
                operationsStack.push("+" + num2);
                break;
            case "-":
                result = num1 - num2;
                logger.log(Level.INFO, "Выполнено вычитание " + num1 + " - " + num2);
                operationsStack.push("-" + num2);
                break;
            case "*":
                result = num1 * num2;
                logger.log(Level.INFO, "Выполнено умножение " + num1 + " * " + num2);
                operationsStack.push("*" + num2);
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                    logger.log(Level.INFO, "Выполнено деление " + num1 + " / " + num2);
                    operationsStack.push("/" + num2);
                } else {
                    isValidOperator = false;
                    logger.log(Level.SEVERE, "Деление на ноль недопустимо!");
                }
                break;
            case "delete":
                if (!operationsStack.isEmpty()) {
                    String lastOperation = operationsStack.pop();
                    operator = lastOperation.substring(0, 1);
                    num2 = Double.parseDouble(lastOperation.substring(1));
                    isValidOperator = false; 
                    logger.log(Level.INFO, "Отменена операция: " + num1 + " " + operator + " " + num2);
                } else {
                    isValidOperator = false;
                    logger.log(Level.WARNING, "Нет операций для отмены!");
                }
                break;
            default:
                isValidOperator = false;
                logger.log(Level.SEVERE, "Некорректный оператор!");
                break;
        }

        if (isValidOperator) {
            logger.log(Level.INFO, "Результат: " + result);
            System.out.println("Результат: " + result);
        } else {
            System.out.println("Что-то пошло не так. Пожалуйста, проверьте введенные данные.");
        }
}



    // Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть
    // заменены знаком вопроса, например,
    // 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
    // Предложить хотя бы одно
    // решение или сообщить, что его нет.

    static void ex4() {
        System.out.println("Не решено");
    }

    // Дана строка sql-запроса "select * from students where ". Сформируйте часть
    // WHERE этого запроса, используя StringBuilder.
    // Данные для фильтрации приведены ниже в виде json-строки.
    // Если значение null, то параметр не должен попадать в запрос.
    // Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
    // "city":"Moscow", "age":"null"}

    static void ex5() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", "Moskow");
        map.put("age", null);

        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        if (params == null || params.isEmpty())
            return result.toString();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null)
                continue;

            result.append(pair.getKey()).append(" : '").append(pair.getValue()).append("' and ");
        }

        if (result.length() > 5)
            result.delete(result.length() - 5, result.length());

        return result.toString();
    }

    // Реализуйте алгоритм сортировки пузырьком числового массива, результат после
    // каждой итерации запишите в лог-файл.

    static void ex6() throws IOException {
        Logger logger = Logger.getLogger(homeworks.class.getName());
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("Sort Array");
        int[] array = { 2, 5, 1, -7, 3, 64, 0 };
        ((PrintStream) lib).print(array);
        int[] newArr = listSort(array);
        System.out.printf("\n Отсортированный массив: \n");
        ((PrintStream) lib).print(newArr);
    }

    public static int[] listSort(int[] arr) {
        for (int k = 0; k < arr.length - 1; k++) {

            for (int i = 0; i < arr.length - k - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    // Дана json-строка (можно сохранить в файл и читать из файла)
    // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    // Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
    // строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
    // Пример вывода:
    // Студент Иванов получил 5 по предмету Математика.
    // Студент Петрова получил 4 по предмету Информатика.
    // Студент Краснов получил 5 по предмету Физика.

    static void ex7() {
        System.out.println("Не решено");
    }

    // Пусть дан произвольный список целых чисел.
    // 1) Нужно удалить из него чётные числа
    // 2) Найти минимальное значение
    // 3) Найти максимальное значение
    // 4) Найти среднее значение

    static void deleteEvens(List<Integer> arrList) {
        for (int i = 0; i < arrList.size() - 1; i++) {
            if (arrList.get(i) % 2 == 0) {
                arrList.remove(i);
            }
        }
        System.out.println("Остаток после удаления чётный чисел: " + arrList);
    }

    static Integer MinNum(List<Integer> arrList) {
        int min = arrList.get(0);
        for (int i = 0; i < arrList.size() - 1; i++) {
            if (arrList.get(i) < min) {
                min = arrList.get(i);
            }
        }
        return min;
    }

    static Integer MaxNum(List<Integer> arrList) {
        int max = arrList.get(0);
        for (int i = 0; i < arrList.size() - 1; i++) {
            if (arrList.get(i) > max) {
                max = arrList.get(i);
            }
        }
        return max;
    }

    static Double Median(List<Integer> arrList) {
        int sum = 0;
        double Median;
        for (int i = 0; i < arrList.size() - 1; i++) {
            sum += arrList.get(i);
        }
        Median = sum / arrList.size();
        return Median;
    }

    public static void ex8() {
        List<Integer> list_num = new ArrayList(Arrays.asList(4, 263, 6, 92, 458, 36, 4, 37, 157, 30));
        System.out.println("Изначальный список: " + list_num);
        System.out.println("Минимальное значение: " + MinNum(list_num));
        System.out.println("Максимальное значение: " + MaxNum(list_num));
        System.out.println("Среднее значение: " + Median(list_num));
        deleteEvens(list_num);
    }



    // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    
    static void ex9() {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        
        System.out.println("Исходный список: " + linkedList);
        
        LinkedList<Integer> reversedList = reverseLinkedList(linkedList);
        
        System.out.println("Перевернутый список: " + reversedList);
    }
    
    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list) {
        LinkedList<T> reversedList = new LinkedList<>();
        
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        
        return reversedList;
    }


    //Реализуйте очередь с помощью LinkedList со следующими методами:
    //enqueue() - помещает элемент в конец очереди,
    //dequeue() - возвращает первый элемент из очереди и удаляет его,
    //first() - возвращает первый элемент из очереди, не удаляя.

    static void ex10(){
        System.out.println("Не выполнено.");
}
}





