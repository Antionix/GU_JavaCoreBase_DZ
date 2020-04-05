package ru.geekbrains.lesson07;

public class Cats {
    private String name;
    private int appetite;
    private boolean full = false;

    public Cats(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plates p) {
        if (full) {
            System.out.printf("Кот %s не покушал, он сыт\n------\n", name);
        } else {
            if (p.getFood() >= appetite) {
                p.decreaseFood(appetite);
                full = true;
                System.out.printf("Кот %s покушал\n------\n", name);
            } else {
                full = false;
                System.out.printf("Кот %s не покушал, мало еды\n------\n", name);
            }
        }
    }

    @Override
    public String toString() {
        if (full) {
            return "Это сытый " + name + " и у него отменный аппетит {" + appetite + "}";
        } else {
            return "Это голодный " + name + " и у него отменный аппетит {" + appetite + "}";
        }
    }
}
