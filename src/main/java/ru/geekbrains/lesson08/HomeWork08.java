package ru.geekbrains.lesson08;

public class HomeWork08 {
    public static final int SIZE_MAP = 15;
    public static final int DOTS_TO_WIN = 4;
//    public static final char DOT_EMPTY = '_';
//    public static final char DOT_X = 'X';
//    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        System.out.println("===== Домашняя работа 08 =====");

        GameWindows Windows = new GameWindows(SIZE_MAP, DOTS_TO_WIN);
    }
}
