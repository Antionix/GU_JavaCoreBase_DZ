package ru.geekbrains.lesson08;

public class UserGamer {
    private char gameChar;

    public UserGamer(char ch) {
        gameChar = ch;
    }

    public char getGameChar() {
        return gameChar;
    }

    public void stepGamer(Maps map, String cc) {
        int x, y;
        x = Integer.parseInt(cc.substring(0,2));
        y = Integer.parseInt(cc.substring(2,4));

//        System.out.println("Gamer step " + cc);
//        System.out.println("Gamer step " + x + " - " + y);

        map.setCell(x,y,gameChar);
    }
}
