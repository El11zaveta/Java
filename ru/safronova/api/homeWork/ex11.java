package ru.safronova.api.homeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ex11 {
    private Map<String, List<String>> directory;

    public ex11() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        List<String> phoneNumbers = directory.getOrDefault(lastName, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        directory.put(lastName, phoneNumbers);
    }

    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, new ArrayList<>());
    }

    public static void main(String[] args) {
        ex11 phoneDirectory = new ex11();

        // Добавление записей в телефонный справочник
        phoneDirectory.add("Иванов", "123456789");
        phoneDirectory.add("Петров", "987654321");
        phoneDirectory.add("Сидоров", "111111111");
        phoneDirectory.add("Иванов", "555555555");

        // Поиск номеров телефонов по фамилии
        List<String> ivanovPhoneNumbers = phoneDirectory.get("Иванов");
        System.out.println("Номера телефонов Ивановых: " + ivanovPhoneNumbers);

        List<String> petrovPhoneNumbers = phoneDirectory.get("Петров");
        System.out.println("Номера телефонов Петровых: " + petrovPhoneNumbers);

        List<String> smithPhoneNumbers = phoneDirectory.get("Смит");
        System.out.println("Номера телефонов Смитовых: " + smithPhoneNumbers);
    }
}
