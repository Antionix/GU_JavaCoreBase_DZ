package ru.geekbrains.kesson05;
/*
* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
* Конструктор класса должен заполнять эти поля при создании объекта;
* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
* Создать массив из 5 сотрудников
* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
*/

import ru.geekbrains.lesson05.Person;

public class HomeWork05 {

    public static void main(String[] args) {
        System.out.println("***** Mw home work - lesson 05 *****");

        Person Ivan = new Person("Иванов Иван Иванович",
                "Директор",
                "ivanov@firma.ru",
                "+7(000)123-4567",
                120000, 45);
        System.out.println(Ivan);
        Ivan.getInfo();

        Person[] personArray = new Person[5];
        personArray[0] = new Person("Иванов Иван Иванович",
                "Директор",
                "ivanov@firma.ru",
                "+7(000)123-4567",
                120000, 45);

        personArray[1] = new Person("Федоров Федор Федорович",
                "Заместитель директора",
                "fedorov@firma.ru",
                "+7(000)123-4568",
                100000, 38);

        personArray[2] = new Person("Сидорова Марина Ивановна",
                "Главный бухгадтер",
                "sidorova@firma.ru",
                "+7(000)123-4569",
                120000, 41);

        personArray[3] = new Person("Пришлый Инокентий Львович",
                "Менеджер",
                "prishliy@firma.ru",
                "+7(000)123-4570",
                120000, 23);

        personArray[4] = new Person("Петров Петр Петрович",
                "Менеджер",
                "petrov@firma.ru",
                "+7(000)123-4570",
                120000, 25);

        System.out.println("\n----print array ----");
        for (Person person : personArray) {
            System.out.println(person);
        }

        System.out.println("\nСотрудники старше 40 лет");
        for (Person p : personArray) {
            if (p.getAge() >= 40) {
                p.getInfo();
            }

        }

    }
}
