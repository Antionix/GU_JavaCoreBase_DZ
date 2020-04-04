package ru.geekbrains.lesson05;
/*
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 */

public class Person {
    private String nameFIO;
    private String position;
    private String email;
    private String phone;
    private float cash;
    private int age;

    public Person(String name, String position, String email, String phone, float cash, int age) {
        this.nameFIO = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.cash = cash;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameFIO:" + nameFIO +
                ", position:" + position +
                ", email:" + email +
                ", phone:" + phone +
                ", cash:" + cash +
                ", age:" + age +
                "}";
    }

    public void getInfo() {
        System.out.println("\n===== Информация о сотруднике =====");
        System.out.println("Фамилия Имя Отчество: " + nameFIO);
        System.out.println("Должность: " + position);
        System.out.println("Адрес эл.почты: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Оклад:" + cash);
        System.out.println("Возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}
