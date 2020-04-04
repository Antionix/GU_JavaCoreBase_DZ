package ru.geekbrains.lesson06;

import ru.geekbrains.lesson06.Animals;

public class Cats extends Animals {
    String color;
    private final float MAX_JUMP = 2f;
    private final int MAX_RUN = 200;
    public static int numbersCats = 0;

    public Cats() {
        this.name = "cat";
        this.color = "неизвестен";
        numbersCats++;
    }

    public Cats(String name, String color) {
        this.name = name;
        this.color = color;
        numbersCats++;
    }

    @Override
    public void getInfo() {
        System.out.println("Кошка " + name + ", окрас " + color);
    }

    @Override
    public boolean jump(float height) {
//        System.out.print("{jump = " + height + "} ");
        if (height < 0) {
            System.out.println("Кошка " + name + " не стала прыгать.");
            return false;
        } else if (height > MAX_JUMP) {
            System.out.println("Кошка " + name + " прыгнула на " + MAX_JUMP + " метра.");
            return false;
        } else {
            System.out.printf("Кошка %s прыгнула на %.2f метра.\n", name, height);
            return true;
        }
    }

    @Override
    public boolean run(int length) {
//        System.out.print("{run = "+ length +"} ");
        if (length < 0) {
            System.out.println("Кошка " + name + " не стала бежать.");
            return false;
        } else if (length > MAX_RUN) {
            System.out.println("Кошка " + name + " пробежала " + MAX_RUN + " метров и остановилась.");
            return false;
        } else {
            System.out.println("Кошка " + name + " пробежала " + length + " метров.");
            return true;
        }
    }

    @Override
    public boolean swim(int length) {
//        System.out.print("{swim = "+ length +"} ");
        System.out.println("Кошка " + name + " не умеет плвать.");
        return false;
    }
}