package ru.geekbrains.lesson02;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;

public class HomeWork2 {

    public static int[] initRandomArray(int count, int maxValue) {
        int[] tmp = new int[count];
        for (int i = 0; i < count; i++) {
            tmp[i] = (int) (Math.random() * (maxValue + 1));
//            System.out.print("[" + tmp[i] + "]");
        }
//        System.out.println();
        return tmp;
    }

    /*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */
    public static int[] getChange0And1(int[] arrayValue) {
        for (int i = 0; i < arrayValue.length; i++) {
            switch (arrayValue[i]) {
                case 1: {
                    arrayValue[i] = 0;
                    break;
                }
                case 0: {
                    arrayValue[i] = 1;
                    break;
                }
                default: {
                    arrayValue[i] = -1;
                }
            }
        }
        return arrayValue;
    }

    /*
    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    */
    public static int[] initArrayByStep(int count, int steps) {
        int[] tmp = new int[count];
        for (int i = 0, x = 0; i < count; i++, x += steps) {
            tmp[i] = x;
//            System.out.print("[" + tmp[i] + "]");
        }
//        System.out.println();
        return tmp;
    }

    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */
    public static void getChangeLess6(int[] arrayValue) {
        System.out.print("03  inArray = ");
        for (int x : arrayValue) {
            System.out.print("[" + x + "]");
        }
        System.out.print("\n03 outArray = ");
        for (int x : arrayValue) {
            if (x < 6) {
                System.out.print("[" + (x * 2) + "]");
            } else {
                System.out.print("[" + x + "]");
            }
        }
        System.out.println("\n");
    }
/*
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
 заполнить его диагональные элементы единицами;
*/

/*
5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
*/

/*
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
граница показана символами ||, эти символы в массив не входят.
*/

/*
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
нельзя пользоваться вспомогательными массивами.
*/

/*
8. Найти 3 минимальный элемент массива
 */

    public static void main(String[] args) {
        System.out.println("Home work 2");

        // Задание 1
        int[] initArray = initRandomArray(5, 1);
        System.out.print("01 InitArray = ");
        for (int curV : initArray) {
            System.out.print("[" + curV + "]");
        }
        System.out.print("\n01 ItogArray = ");
        for (int curV : getChange0And1(initArray)) {
            System.out.print("[" + curV + "]");
        }
        System.out.println("\n");

        //Задание 2
        System.out.print("02 StepArray = ");
        for (int curV : initArrayByStep(8, 2)) {
            System.out.print("[" + curV + "]");
        }
        System.out.println("\n");

        //Задание 3
        int[] curArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        getChangeLess6(curArray);

    }
}
