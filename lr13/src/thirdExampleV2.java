package secondTask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class thirdExampleV2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = 0;

        // Ввод длины массива
        while (true) {
            System.out.print("Введите размер массива (> 0): ");
            try {
                length = Integer.parseInt(in.nextLine());
                if (length > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: размер должен быть больше 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число!");
            }
        }

        byte[] array = new byte[length];

        for (int i = 0; i < length; i++) {
            while (true) {
                System.out.print("Введите элемент " + i + " (от -128 до 127): ");
                try {
                    int input = Integer.parseInt(in.nextLine());
                    if (input < Byte.MIN_VALUE || input > Byte.MAX_VALUE) {
                        System.out.println("Ошибка: число вне диапазона byte!");
                    } else {
                        array[i] = (byte) input;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите корректное целое число!");
                }
            }
        }
        try {
            byte sum = calculateByteSum(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка при вычислении суммы: " + e.getMessage());
        }

        in.close();
    }

    public static byte calculateByteSum(byte[] arr) {
        int sum = 0;
        for (byte b : arr) {
            sum += b;
            if (sum > Byte.MAX_VALUE || sum < Byte.MIN_VALUE) {
                throw new ArithmeticException("Сумма вышла за границы byte (" + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE + ")");
            }
        }
        return (byte) sum;
    }
}