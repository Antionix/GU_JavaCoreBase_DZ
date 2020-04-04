package ru.geekbrains.lesson04;
/*
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

import java.util.Scanner;

public class HomeWork04 {
    public static char[][] map;
    public static final int SIZE_MAP = 15;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '_';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);

    private static void initMap() {
        map = new char[SIZE_MAP][SIZE_MAP];
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {

        if ((int) SIZE_MAP / 10 > 0) {
            for (int i = 0; i <= (int) SIZE_MAP / 10; i++) {
                System.out.print("\n   ");
                for (int z = 1; z <= SIZE_MAP; z++) {
                    if (i == 0) {
                        System.out.printf("%2d", (int) z / 10);
                    } else {
                        System.out.printf("%2d", z % 10);
                    }
                }
//                System.out.println();
            }
        } else {
            System.out.print("   ");
            for (int i = 0; i < SIZE_MAP; i++) {
                System.out.printf("%2d ", (i + 1));
            }
        }
        System.out.println();

        for (int i = 0; i < SIZE_MAP; i++) {
            System.out.printf("%2d |", (i + 1));
            for (int j = 0; j < SIZE_MAP; j++) {
                System.out.print(map[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean notFullMap() {
        int cellFull = 0;
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                if (map[i][j] == DOT_O || map[i][j] == DOT_X) {
                    cellFull++;
                }
            }
        }
//        System.out.println(cellFull);
        return cellFull != SIZE_MAP * SIZE_MAP;
    }

    private static boolean checkVLine(int x, int y, char ch) {
        int cellChar = 0;
        boolean toWin = false;

        for (int v = 0; v < DOTS_TO_WIN; v++) {
            cellChar = 0;
            for (int h = 0; h < DOTS_TO_WIN; h++) {
                if (map[x + h][y + v] == ch) {
                    cellChar++;
                }
            }
            if (cellChar == DOTS_TO_WIN) {
                toWin = true;
                break;
            }
        }
        return toWin;
    }

    private static boolean checkHLine(int x, int y, char ch) {
        int cellChar = 0;
        boolean toWin = false;

        for (int h = 0; h < DOTS_TO_WIN; h++) {
            cellChar = 0;
            for (int v = 0; v < DOTS_TO_WIN; v++) {
                if (map[x + h][y + v] == ch) {
                    cellChar++;
                }
            }
            if (cellChar == DOTS_TO_WIN) {
                toWin = true;
                break;
            }
        }
        return toWin;
    }

    private static boolean checkDLine(int x, int y, char ch) {
        int cellChar = 0;
        boolean toWin = false;

        for (int h = 0; h < DOTS_TO_WIN; h++) {
            for (int v = 0; v < DOTS_TO_WIN; v++) {
                if (h == v && map[x + h][y + v] == ch) {
                    cellChar++;
                }
            }
        }
        toWin = (cellChar == DOTS_TO_WIN);

        cellChar = 0;
        if (!toWin) {
            for (int h = 0; h < DOTS_TO_WIN; h++) {
                for (int v = (DOTS_TO_WIN - 1); v >= 0; v--) {
                    if (h == (DOTS_TO_WIN - v - 1) && map[x + h][y + v] == ch) {
                        cellChar++;
                    }
                }
            }
            toWin = (cellChar == DOTS_TO_WIN);
        }

        return toWin;
    }

    private static boolean verifyWin(char gameChar) {
        boolean toWin = false;
        for (int h = 0; h < (SIZE_MAP - DOTS_TO_WIN); h++) {
            for (int v = 0; v < (SIZE_MAP - DOTS_TO_WIN); v++) {

                toWin = checkHLine(h, v, gameChar);
                if (toWin) {
                    return toWin;
                }

                toWin = checkVLine(h, v, gameChar);
                if (toWin) {
                    return toWin;
                }

                toWin = checkDLine(h, v, gameChar);
                if (toWin) {
                    return toWin;
                }
            }
        }
        return toWin;
    }

    private static boolean changeCellMap(int x, int y, char s) {
        if (map[x][y] == DOT_EMPTY) {
            map[x][y] = s;
            return true;
        } else {
            System.out.println("Ячейка [" + (x + 1) + "," + (y + 1) + "] занята");
            return false;
        }
    }

    private static void stepGamer(char chG) {
        int x = -1, y = -1;
        do {
            printMap();
            System.out.println("Ваш ход: ");
            x = sc.nextInt();
            y = sc.nextInt();
            x--;
            y--;
        } while (!changeCellMap(x, y, chG));
    }

    private static void stepComputer(char chC) {
        int x = -1;
        int y = -1;
        int z = -1;
        boolean stepRun = true;

        if (notFullMap()) {
            while (stepRun) {
                z = (int) (Math.random() * 100);
                x = z % SIZE_MAP;
                z = (int) (Math.random() * 100);
                y = z % SIZE_MAP;

                if (map[x][y] == DOT_EMPTY) {
                    map[x][y] = chC;
                    stepRun = false;
                }
            }
        } else {
            System.out.println("Нет пустых клеток");
        }
    }

    public static void main(String[] args) {
        System.out.println("***** My Home Work 04 *****");
        char charGamer = DOT_EMPTY;
        char charComp = DOT_EMPTY;
        int step = 0;
        boolean inGame = true;

        initMap();
        System.out.println(notFullMap());
        System.out.println("Начинаем играть в крестики-нолики");

        int x = -1;
        do {
            System.out.println("Выберите, чем будите игнать? (1 - крестики, 0 - нолики):");
            x = sc.nextInt();
            switch (x) {
                case 0: {
                    charGamer = DOT_O;
                    charComp = DOT_X;
                    break;
                }
                case 1: {
                    charGamer = DOT_X;
                    charComp = DOT_O;
                    break;
                }
                default: {
                    x = -1;
                    System.out.println("Неправильный выбор");
                }
            }
        } while (x == -1);

        inGame = notFullMap();
        while (inGame) {
//            System.out.println(inGame);
//            printMap();
            stepGamer(charGamer);
            if (verifyWin(charGamer)) {
                System.out.println("Вы выиграли");
                break;
            }
            ;
            stepComputer(charComp);
            if (verifyWin(charComp)) {
                System.out.println("Выиграл компьютер");
                break;
            }

            inGame = notFullMap();
        }

        printMap();
    }
}
