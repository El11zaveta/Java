package ru.safronova.api.homeWork;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ex12 {
    public static void main(String[] args) {
        Set<Cat> catSet = new HashSet<>();

        Cat cat1 = new Cat("Whiskers", 2);
        Cat cat2 = new Cat("Tom", 3);
        Cat cat3 = new Cat("Whiskers", 2);

        catSet.add(cat1);
        catSet.add(cat2);
        catSet.add(cat3);

        System.out.println("Содержимое множества:");
        for (Cat cat : catSet) {
            System.out.println(cat);
        }
    }
}
