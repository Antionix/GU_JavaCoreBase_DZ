package ru.geekbrains.lesson06;
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
   В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
    или высоту (для прыжков).
3. У каждого животного есть ограничения на действия
   (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
   (Например, dog1.run(150); -> результат: run: true)
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
6. * Добавить подсчет созданных котов, собак и животных

 */

public class myHomeWork06 {
    public static void main(String[] args) {
        System.out.println("===== Домашняя работа 06 =====");

        Cats[] flockCats = new Cats[2];
        flockCats[0] = new Cats("Барсик", "Рыжий");
        flockCats[1] = new Cats("Фантик", "Черный");

//        Cats cat1 = new Cats("Барсик", "Рыжий");
//        Cats cat2 = new Cats("Фантик", "Черный");
//
//        System.out.println("Количество животных: " + Animals.numberAnimals);
//        System.out.println("Количество собак: " + Dogs.numbersDogs);
//        System.out.println("Количество кошек: " + Cats.numbersCats);

        Dogs[] flockDogs = new Dogs[3];
        flockDogs[0] = new Dogs("Палкан");
        flockDogs[1] = new Dogs("Бим");
        flockDogs[2] = new Dogs("Мухтар");
//        Dogs dog1 = new Dogs("Палкан");
//        Dogs dog2 = new Dogs("Бим");
//        Dogs dog3 = new Dogs("Мухтар");

        System.out.println("Количество животных: " + Animals.numberAnimals);
        System.out.println("Количество собак: " + Dogs.numbersDogs);
        System.out.println("Количество кошек: " + Cats.numbersCats);

        System.out.println("-------------------------------------------");
        for (Cats flockCat : flockCats) {
            flockCat.getInfo();
            System.out.println("jump:" + flockCat.jump((float) Math.random()));
            System.out.println("run:" + flockCat.run((int) (Math.random() * 500)));
            System.out.println("swim:" + flockCat.swim((int) (Math.random() * 50)));
            System.out.println("-------------------------------------------");
        }

        for (Dogs flockDog : flockDogs) {
            flockDog.getInfo();
            System.out.println("jump:" + flockDog.jump((float) Math.random()));
            System.out.println("run:" + flockDog.run((int) (Math.random() * 1000)));
            System.out.println("swim:" + flockDog.swim((int) (Math.random() * 100)));
            System.out.println("-------------------------------------------");
        }
    }
}
