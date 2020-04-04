package ru.geekbrains.lesson03;

/*
1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */

import java.util.Scanner;

public class HomeWork03a {
    public static int getRandomValue() {
        return (int) (Math.random() * 9);
    }

    public static Scanner sc = new Scanner(System.in);

    public static void loopAsk2Answer(int step) {
        int selectNumber = getRandomValue();
        boolean gameStatus = false;
        System.out.println("Загадано случайное число от 0 до 9");
//        System.out.println(selectNumber);

        for (int i = 0; i < step; i++) {

            System.out.println("Попытка " + (i + 1) + ":");
            int currentValue = sc.nextInt();
//            System.out.println(currentValue);

            if (currentValue > selectNumber) {
                System.out.print("Вы не угадали. Загаданное число меньше. ");
                if (i < (step -1)) {
                    System.out.println("Поробуйте еще раз.");
                };
            } else if (currentValue < selectNumber) {
                System.out.print("Вы не угадали. Загаданное число больше. ");
                if (i < (step -1)) {
                    System.out.println("Поробуйте еще раз.");
                };
            } else {
                System.out.println("Вы угадали с " + (i + 1) + " попытки. Загадано число " + selectNumber);
                gameStatus = true;
                break;
            }
        }
        if (!gameStatus) {
            System.out.println("Попытки закончились. Число не угадано.");
        }
    }

    public static boolean askGame(boolean gameFlag) {
        boolean dlgStatus = true;
        do {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int x = sc.nextInt();
            switch (x) {
                case 0: {
                    dlgStatus = false;
                    gameFlag = false;
                    break;
                }
                case 1: {
                    dlgStatus = false;
                    gameFlag = true;
                    break;
                }
                default:
                {
                    System.out.println("Введено неправильное значение. (1 – повторить, 0 – нет)");
                    dlgStatus = true;
                }
            }
        } while (dlgStatus);
        return gameFlag;
    }

    public static void main(String[] args) {
        System.out.println("--- HomeWork 03 (Угадай число) ---");

        boolean gameFlag = false;

        System.out.println("*** Игра начинается ***");
        do {
            loopAsk2Answer(3);
        } while (askGame(gameFlag));

        System.out.println("*** Игра заверщена ***");
    }
}
