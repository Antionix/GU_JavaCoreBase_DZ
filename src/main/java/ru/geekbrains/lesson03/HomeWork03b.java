package ru.geekbrains.lesson03;

import java.util.Scanner;

/*
2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
 */
public class HomeWork03b {
    private static Scanner sc = new Scanner(System.in);

    public static String getRandomWord(String[] wordArray) {
        int x = (int) (Math.random() * wordArray.length);
        return wordArray[x];
    }

    private static void loopAskWord(String selectWord) {
        String currentWord = "";
        String tmpWord = "";
        int countStep = -1;
        int cycleRange = 0;
        boolean loopGame = true;
        int lenSelWord = selectWord.length();

        while (loopGame) {
            int rightChar = 0;
            System.out.println("Введите назване фрукта/овоща: ");
            currentWord = sc.next();
            currentWord = currentWord.toLowerCase();
            int lenCurWord = currentWord.length();
            tmpWord = "";

//            countStep++;

            if (lenCurWord < lenSelWord) {
                cycleRange = lenCurWord;
            } else {
                cycleRange = lenSelWord;
            }

            for (int i = 0; i < cycleRange; i++) {
                if (selectWord.charAt(i) == currentWord.charAt(i)) {
                    tmpWord += currentWord.charAt(i);
                    rightChar++;
                } else {
                    tmpWord += "#";
                }
            }

            if (rightChar == lenSelWord) {
                System.out.println("Слово " + selectWord + " угадано");
//                System.out.println("[" + currentWord + "]");
                loopGame = false;
            } else {
                for (int i = tmpWord.length(); i < 15; i++) {
                    tmpWord += "#";
                }
            }

            System.out.println("Результат: " + tmpWord);
//            System.out.println("[" + rightChar + " | " + selectWord + " | " + currentWord + "]");

//            if (countStep == 5) {
//                loopGame = false;
//            }
        }

    }


    public static void main(String[] args) {
        System.out.println("****  HomeWork 03b  (Угадай слово) ****");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.println("*** Игра начинается ***");

        String selectWord = getRandomWord(words);
//        System.out.println(selectWord);
        System.out.println("Загадано название фрукта/овоща из списка:");
        System.out.print(words[0] + ", ");

        for (int i = 1; i < words.length; i++) {
            if ((i % 8) == 1) {
                System.out.print(words[i]);
            } else if ((i % 8) != 0) {
                System.out.print(", " + words[i]);
            } else {
                System.out.println(", " + words[i]);
            }
        }

        loopAskWord(selectWord);

        System.out.println("*** Игра завершена ***");
    }
}
