package ru.geekbrains.lesson08;

import javax.swing.*;
import java.awt.*;

public class GameWindows extends JFrame {
    private final ImageIcon ICON_EMPTY = new ImageIcon("src/image/empty.png");
    private final ImageIcon ICON_X = new ImageIcon("src/image/X.png");
    private final ImageIcon ICON_O = new ImageIcon("src/image/O.png");
    public static final char DOT_EMPTY = '_';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    private static String[] msgStart = {"Крестики", "Нолики"};
    private static String[] msgEnd = {"Новая игра", "Выход"};
    private static boolean gameStatus = true;

    public GameWindows(int sizeMap, int dotsToWin) {
        Maps mapGame = new Maps(sizeMap, DOT_EMPTY, DOT_X, DOT_O, dotsToWin);
        UserGamer gamer;
        CompGamer computer;

        int responseStart = JOptionPane.showOptionDialog(null, "Выберите чем будете играть:",
                "ВЫбор Крести / Нолики", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, msgStart, "Крестики");
        if (responseStart == 0) {
            gamer = new UserGamer(DOT_X);
            computer = new CompGamer(DOT_O);
        } else {
            gamer = new UserGamer(DOT_O);
            computer = new CompGamer(DOT_X);
        }

        setTitle("Игра крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 50 * sizeMap, 50 * sizeMap);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(sizeMap, sizeMap));
        JButton[][] buttons = new JButton[sizeMap][sizeMap];
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(ICON_EMPTY);
                buttons[i][j].setActionCommand(String.format("%02d%02d", i, j));
                JButton copy = buttons[i][j];
                copy.addActionListener(actBtn -> {
                    gamer.stepGamer(mapGame, actBtn.getActionCommand());
                    refreshWindows(mapGame, buttons);

                    if (mapGame.isVerifyWin(gamer.getGameChar())) {
                        JOptionPane.showMessageDialog(null, "Игрок победил",
                                "ПОЮЕДА", JOptionPane.INFORMATION_MESSAGE);
//                        this.dispose();
                        gameStatus = false;
                    } else {
                        computer.stepComp(mapGame, buttons);
                        refreshWindows(mapGame, buttons);

                        if (mapGame.isVerifyWin(computer.getCompChar())) {
                            JOptionPane.showMessageDialog(null, "Компьютер победил", "" +
                                    "ПОРАЖЕНИЕ", JOptionPane.INFORMATION_MESSAGE);
//                            this.dispose();
                            gameStatus = false;
                        }
                    }

                    if (!gameStatus) {
                        int responseEnd = JOptionPane.showOptionDialog(null, "Игра окончена. Хотите еще поиграть?",
                                "Игра окончена", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, msgEnd, msgEnd[1]);
                        if (responseEnd == 0) {
                            dispose();
                            gameStatus = true;
                            new GameWindows(sizeMap, dotsToWin);
                        } else {
                            dispose();
                        }
                    }

                });
                panel.add(buttons[i][j]);
            }
        }
        add(panel);
        setVisible(true);
    }

    public void refreshWindows(Maps map, JButton[][] buttons) {
        int size = map.getSizeMap();
        char charCell;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                charCell = map.getCell(i, j);
                if (buttons[i][j].isEnabled()) {
                    if (charCell == DOT_X) {
                        buttons[i][j].setIcon(ICON_X);
                        buttons[i][j].setEnabled(false);
                        buttons[i][j].setDisabledIcon(ICON_X);
                    } else if (charCell == DOT_O) {
                        buttons[i][j].setIcon(ICON_O);
                        buttons[i][j].setEnabled(false);
                        buttons[i][j].setDisabledIcon(ICON_O);
                    }
                }
            }
        }
    }
}

