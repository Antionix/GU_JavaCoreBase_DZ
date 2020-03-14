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
        if (a > 20) {
            return false;
        } else if (b > 20) {
            return false;
        } else {
            int sum = a + b;
            if ((sum > 10) && (sum <= 20)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Test");

        getTypeValue();

        System.out.println(calculate(2,4,16,8));

        System.out.println(checkSumIn10Out20(13, 12));
    }
}
