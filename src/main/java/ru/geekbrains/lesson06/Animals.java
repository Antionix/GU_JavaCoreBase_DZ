package ru.geekbrains.lesson06;

public abstract class Animals {
    String name;
    public static int numberAnimals;

    public Animals() {
        this.name = "Животное";
        numberAnimals++;
    }

    public Animals(String name) {
        this.name = name;
        numberAnimals++;
    }

    public void getInfo() {
        System.out.println("Животное {" + name + "}");
    }

    public abstract boolean jump(float height);

    public abstract boolean run(int length);

    public abstract boolean swim(int length);
}
