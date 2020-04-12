package ru.geekbrains.lesson08;

import javax.swing.*;

public class CompGamer {
    private char compChar;

    public CompGamer(char ch) {
        compChar = ch;
    }

    public char getCompChar() {
        return compChar;
    }

    public void stepComp(Maps map, JButton[][] button) {
        boolean stepRun = true;
        int x, y;
        int sizeM = map.getSizeMap();

        if (map.isNotFullMap()) {
            while (stepRun) {
                x = ((int) (Math.random() * 100)) % sizeM;
                y = ((int) (Math.random() * 100)) % sizeM;
//                System.out.printf("%02d - %02d = [ %s - %b ] %b ] %b\n", x, y, map.getCell(x,y), map.isEmptyCell(x,y), button[x][y].isEnabled(), stepRun);
                if (map.isEmptyCell(x, y) && button[x][y].isEnabled()) {
                    map.setCell(x, y, compChar);
                    stepRun = false;
                }
            }
        }
    }
}
