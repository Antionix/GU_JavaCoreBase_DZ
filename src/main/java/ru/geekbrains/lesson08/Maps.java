package ru.geekbrains.lesson08;

public class Maps {
    private char[][] map;
    private int sizeMap;
    private char chEmpty;
    private char chX;
    private char chO;
    private int dotToWin;

    public Maps(int size, char chEmpty, char chX, char chO, int dotToWin) {
        this.sizeMap = size;
        this.map = new char[sizeMap][sizeMap];
        this.dotToWin = dotToWin;
        this.chX = chX;
        this.chO = chO;
        this.chEmpty = chEmpty;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = chEmpty;
            }
        }
    }

    public boolean isEmptyCell(int x, int y) {
        return map[x][y] == this.chEmpty;
    }

    public boolean isNotFullMap() {
        int cellFull = 0;
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                if (map[i][j] == this.chO || map[i][j] == this.chX) {
                    cellFull++;
                }
            }
        }
        return cellFull != sizeMap * sizeMap;
    }

    public boolean setCell(int x, int y, char dotChar) {
        if (isEmptyCell(x, y)) {
            map[x][y] = dotChar;
            return true;
        } else {
            return false;
        }
    }

    public char getCell(int x, int y) {
        //pass
        return map[x][y];
    }

    public int getSizeMap() {
        return this.sizeMap;
    }

    private boolean isCheckVLine(int x, int y, char ch) {
        int cellChar;
        boolean toWin = false;

        for (int v = 0; v < dotToWin; v++) {
            cellChar = 0;
            for (int h = 0; h < dotToWin; h++) {
                if (map[x + h][y + v] == ch) {
                    cellChar++;
                }
            }
            if (cellChar == dotToWin) {
                toWin = true;
                break;
            }
        }
        return toWin;
    }

    private boolean isCheckHLine(int x, int y, char ch) {
        int cellChar;
        boolean toWin = false;

        for (int h = 0; h < dotToWin; h++) {
            cellChar = 0;
            for (int v = 0; v < dotToWin; v++) {
                if (map[x + h][y + v] == ch) {
                    cellChar++;
                }
            }
            if (cellChar == dotToWin) {
                toWin = true;
                break;
            }
        }
        return toWin;
    }

    private boolean isCheckDLine(int x, int y, char ch) {
        int cellChar = 0;
        boolean toWin = false;

        for (int h = 0; h < dotToWin; h++) {
            for (int v = 0; v < dotToWin; v++) {
                if (h == v && map[x + h][y + v] == ch) {
                    cellChar++;
                }
            }
        }
        toWin = (cellChar == dotToWin);

        cellChar = 0;
        if (!toWin) {
            for (int h = 0; h < dotToWin; h++) {
                for (int v = (dotToWin - 1); v >= 0; v--) {
                    if (h == (dotToWin - v - 1) && map[x + h][y + v] == ch) {
                        cellChar++;
                    }
                }
            }
            toWin = (cellChar == dotToWin);
        }

        return toWin;
    }

    public boolean isVerifyWin(char gameChar) {
        boolean toWin = false;
        for (int h = 0; h < (sizeMap - dotToWin); h++) {
            for (int v = 0; v < (sizeMap - dotToWin); v++) {

                toWin = isCheckHLine(h, v, gameChar);
                if (toWin) {
                    return toWin;
                }

                toWin = isCheckVLine(h, v, gameChar);
                if (toWin) {
                    return toWin;
                }

                toWin = isCheckDLine(h, v, gameChar);
                if (toWin) {
                    return toWin;
                }
            }
        }
        return toWin;
    }
}
