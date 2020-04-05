package ru.geekbrains.lesson07;

public class Plates {
    private int food;

    public Plates(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "В тарелке " + food + " ед.еды";
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int n) {
        if (n > food) {
            food = 0;
            System.out.printf("Тарелка пуста {%d}\n", food);
        } else {
            food -= n;
            System.out.printf("В тарелке осталась еда {%d}\n", food);
        }
    }

    public void addFood(int n) {
        food += n;
    }
}
