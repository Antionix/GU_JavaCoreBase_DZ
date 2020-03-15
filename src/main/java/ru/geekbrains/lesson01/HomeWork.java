package ru.geekbrains.lesson01;

// Создать переменные всех пройденных типов данных, и инициализировать их значения;
public class HomeWork {
    public static void  getTypeValue() {
        byte byteValue = 10;
        System.out.println("byteValue = " + byteValue);

        short shortValue = 0;
        System.out.println("shortValue = " + shortValue);

        int intValue = 2;
        System.out.println("intValue = " + intValue);

        long longValue = 1;
        System.out.println("longValue = " + longValue);

        float floatValue = 1.5f;
        System.out.println("floatValue = " + floatValue);

        double doubleValue = 3.2;
        System.out.println("doubleValue = " + doubleValue);

        char charValue = 'J';
        System.out.println("charValue = " + charValue);

        boolean booleanValue = true;
        System.out.println("booleanValue = " + booleanValue);
    }

/*
 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
 где a, b, c, d – входные параметры этого метода;
 */
    public static int calculate(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }
/*
 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
 если да – вернуть true, в противном случае – false;
 */
    public static boolean checkSumIn10Out20(int a, int b) {
        if ((a > 20) || (b > 20)) {
            return false;
        } else {
            int sum = a + b;
            return (sum > 10) && (sum <= 20);
        }
    }

/*
    5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
*/
    public static void isPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

/*
    6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
*/
    public static boolean isNegative(int a) {
        return a < 0;
    }

/*
    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в
    консоль сообщение «Привет, указанное_имя!»;
 */
    public static void isWelcome(String name) {
        System.out.println("Приыет, "+name);
    }

/*
    8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
*/
    public static void isLeapYear(int year) {
        if (year % 400 == 0) {
            System.out.println("Год " + year +" - Високосный");
        } else if (year % 100 == 0) {
            System.out.println("Год " + year + " - не Високосный");
        } else if (year % 4 == 0) {
            System.out.println("Год " + year + " - Високосный");
        } else {
            System.out.println("Год " + year + " - не Високосный");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test");

        getTypeValue();

        System.out.println(calculate(2,4,16,8));

        System.out.println(checkSumIn10Out20(23, 12));
        System.out.println(checkSumIn10Out20(13, 12));
        System.out.println(checkSumIn10Out20(13, 32));

        isPositiveOrNegative(5);
        isPositiveOrNegative(-10);

        System.out.println(isNegative(-5));
        System.out.println(isNegative(10));

        isWelcome("Geekbrains");

        isLeapYear(2020);
        isLeapYear(2000);
        isLeapYear(1900);
        isLeapYear(1981);
    }
}
