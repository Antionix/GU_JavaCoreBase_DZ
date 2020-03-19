package ru.geekbrains.lesson02;

public class HomeWork2 {

    public static int[] initRandomArray(int count, int maxValue, int flagSign) {
        int[] tmp = new int[count];
        for (int i = 0; i < count; i++) {
            tmp[i] = (int) (Math.random() * (maxValue + 1) - (maxValue * flagSign / 2));
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
    public static void getMatrix(int count) {
        int[][] tmp = new int[count][count];
        for (int x = 0; x < count; x++) {
            for (int y = 0; y < count; y++) {
                if (x == y) {
                    tmp[x][y] = 1;
                } else if (x == (count - y - 1)) {
                    tmp[x][y] = 1;
                } else {
                    tmp[x][y] = 0;
                }
            }
        }
        for (int x = 0; x < count; x++) {
            for (int y = 0; y < count; y++) {
                System.out.print("[" + tmp[x][y] + "]");
            }
            System.out.println();
        }
    }

    /*
    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    */
    public static void getMinMaxElement(int[] inArray) {
        int minValue = inArray[0], maxValue = inArray[0];
        System.out.print("05 inArray = ");
        for (int x : inArray) {
            if (x < minValue) {
                minValue = x;
            }
            if (x > maxValue) {
                maxValue = x;
            }
            System.out.print("[" + x + "]");
        }
        System.out.println("\n05 MinElement = " + minValue + " MaxElement = " + maxValue);
    }

    /*
    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят.
    */
    public static boolean getEqualLeftRight(int[] inArray) {
        System.out.print("\n06 inArray = ");
        for (int x : inArray) {
            System.out.print("[" + x + "]");
        }
        System.out.println();

        int positionLeft = 0, positionRight = inArray.length - 1;
//        int sumLeft = inArray[positionLeft++], sumRight = inArray[positionRight--];
        int sumLeft = 0, sumRight = 0;
//        positionLeft++;
//        positionRight--;
        while (positionLeft <= positionRight) {
            if (sumLeft > sumRight) {
                sumRight += inArray[positionRight--];
//                positionRight--;
            }
            if (sumLeft <= sumRight) {
                sumLeft += inArray[positionLeft++];
//                positionLeft++;
            }
        }
        return sumLeft == sumRight;
    }

    /*
    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
    нельзя пользоваться вспомогательными массивами.
    */
    public static int[] getMoveToNv1(int[] inArray, int nMove) {
        int lenArray = inArray.length;
        int[] tmp = new int[lenArray];
        int xx = lenArray - nMove;
//        int yy = lenArray + xx;
        int zz = 0;
        for (int i = 0; i < lenArray; i++, xx++) {
            zz = xx % lenArray;
            tmp[i] = inArray[zz];
        }
        return tmp;
    }

    public static int[] getMoveToNv2(int[] inArray, int nMove) {
        int lenArray = inArray.length;
        int tmpValue;
//        int step = 0;

        for (int i = 0; i < Math.abs(nMove); i++) {
            if (nMove >= 0) {
                tmpValue = inArray[lenArray - 1];
                for (int j = (lenArray - 2); j >= 0; j--) {
                    inArray[j + 1] = inArray[j];
                }
                inArray[0] = tmpValue;
            } else {
                tmpValue = inArray[0];
//                int zz = lenArray;
                for (int j = 1; j < lenArray; j++) {
                    inArray[j - 1] = inArray[j];
                }
                inArray[lenArray - 1] = tmpValue;
            }
        }
        return inArray;
    }

    /*
    8. Найти 3 минимальный элемент массива
     */
    public static int get3MinElement(int[] inArray) {
        int min3 = 0, tmpMin;
        for (int i = 0; i < 3; i++) {
            tmpMin = inArray[0];
            for (int x : inArray) {
                if (x <= tmpMin) { // && x >= min3) {
                    tmpMin = x;
                }
            }
            min3 = tmpMin;
        }
        return min3;
    }

    public static void main(String[] args) {
        System.out.println("Home work 2");

        // Задание 1
        int[] initArray = initRandomArray(5, 1, 0);
        System.out.print("01 InitArray = ");
        for (int curV : initArray) {
            System.out.print("[" + curV + "]");
        }
        System.out.print("\n01 ItogArray = ");
        for (int curV : getChange0And1(initArray)) {
            System.out.print("[" + curV + "]");
        }
        System.out.println("\n");

        // Задание 2
        System.out.print("02 StepArray = ");
        for (int curV : initArrayByStep(8, 2)) {
            System.out.print("[" + curV + "]");
        }
        System.out.println("\n");

        // Задание 3
        int[] curArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        getChangeLess6(curArray);

        // Задание 4
        getMatrix(7);
        System.out.println();

        // Задание 5
        getMinMaxElement(initRandomArray(7, 10, 1));

        // Задание 6
        int[] testArray = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(getEqualLeftRight(testArray));
        System.out.println(getEqualLeftRight(initRandomArray(12, 3, 0)));

        // Задание 7
        testArray = initRandomArray(7, 5, 0);
        System.out.print("07 inArray = ");
        for (int x : testArray) {
            System.out.print("[" + x + "]");
        }
        int w = -2;
        System.out.print("\n07 Example1 (" + w + ") = ");
        for (int x : getMoveToNv1(testArray, w)) {
            System.out.print("[" + x + "]");
        }
        System.out.print("\n07 Example2 (" + w + ")= ");
        for (int x : getMoveToNv2(testArray, w)) {
            System.out.print("[" + x + "]");
        }
        System.out.println("\n");

        // Задание 8
        testArray = initRandomArray(7, 10, 0);
        System.out.print("08 Array (" + w + ")= ");
        for (int x : testArray) {
            System.out.print("[" + x + "]");
        }
        System.out.println("\n min(3) = " + get3MinElement(testArray));

    }
}
