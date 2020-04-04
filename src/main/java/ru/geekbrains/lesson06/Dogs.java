package ru.geekbrains.lesson06;

import ru.geekbrains.lesson06.Animals;

public class Dogs extends Animals {
    private final float MAX_JUMP = 0.5F + (float) Math.round(Math.random() - 0.5);
    private final int MAX_RUN = 500 + ((int) (Math.random() * 200) - 100);
    private final int MAX_SWIM = 10 + ((int) (Math.random() * 5) - 10);
    public static int numbersDogs = 0;

    public Dogs() {
        numbersDogs++;
    }

    public Dogs(String name) {
        this.name = name;
        numbersDogs++;
    }

    @Override
    public void getInfo() {
        System.out.println("Собака " + name + " может прыгнуть не выше " + MAX_JUMP + " метра.");
        System.out.println("Собака " + name + " может пробежать не более " + MAX_RUN + " метров");
        System.out.println("Собака " + name + " может проплыть не более " + MAX_SWIM + " метров");
    }

    @Override
    public boolean jump(float height) {
//        System.out.print("{jump = "+ height +"} ");
        if (height < 0) {
            System.out.println("Собака " + name + " не стала прыгать.");
            return false;
        } else if (height > MAX_JUMP) {
            System.out.println("Собака " + name + " может прыгнуть только на " + MAX_JUMP + " метра.");
            return false;
        } else {
            System.out.printf("Собака %s прыгнула на %.2f метра.\n", name, height);
            return true;
        }
    }

    @Override
    public boolean run(int length) {
//        System.out.print("{run = "+ length +"} ");
        if (length < 0) {
            System.out.println("Собака " + name + " не стала бежать.");
            return false;
        } else if (length > MAX_RUN) {
            System.out.println("Собака " + name + " пробежала " + MAX_RUN + " метров и остановилась.");
            return false;
        } else {
            System.out.println("Собака " + name + " пробежала " + length + " метров.");
            return true;
        }
    }

    @Override
    public boolean swim(int length) {
//        System.out.print("{swim = "+ length +"} ");
        if (length < 0) {
            System.out.println("Собака " + name + " не стала плыть.");
            return false;
        } else if (length > MAX_SWIM) {
            System.out.println("Собака " + name + " проплыла " + MAX_SWIM + " метров и вернулась назад.");
            return false;
        } else {
            System.out.println("Собака " + name + " проплыла " + length + " метров и вернулась назад.");
            return true;
        }
    }
}
