package ru.geekbrains.lesson07;
/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
   а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
   Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть
   наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести
   информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

public class HomeWork07 {
    public static void main(String[] args) {
        System.out.println("===== Домашняя работа 07 =====");

        Cats[] flockCats = new Cats[6];
        flockCats[0] = new Cats("Барсик", (int) (Math.random() * 50));
        flockCats[1] = new Cats("Пушок", (int) (Math.random() * 50));
        flockCats[2] = new Cats("Фантик",(int) (Math.random() * 50));
        flockCats[3] = new Cats("Черныш",(int) (Math.random() * 50));
        flockCats[4] = new Cats("Рыжик",(int) (Math.random() * 50));
        flockCats[5] = new Cats("Котофей",(int) (Math.random() * 50));

        Plates plate1 = new Plates((int) (Math.random() * 100));
        System.out.println(plate1);
        System.out.println("--------------------");

        for (Cats flockCat : flockCats) {
            System.out.println(flockCat);
        }
        System.out.println("--------------------");

        for (Cats flockCat : flockCats) {
            flockCat.eat(plate1);
        }
        System.out.println("--------------------");

        plate1.addFood((int) (Math.random() * 100));
        System.out.println(plate1);
        System.out.println("--------------------");

        for (Cats flockCat : flockCats) {
            flockCat.eat(plate1);
        }
        System.out.println(plate1);

        for (Cats flockCat : flockCats) {
            System.out.println(flockCat);
        }
    }
}
