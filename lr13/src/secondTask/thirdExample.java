package secondTask;
import java.util.InputMismatchException;
import java.util.Scanner;
public class thirdExample {
    public static void main(String[] args) {
        int length = 2;
        byte[] array = new byte[length];
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < length; i++) {
            while (true) {
                System.out.print("Введите элемент " + i + ": ");
                try {
                    array[i] = in.nextByte();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введите корректное значение типа byte!");
                    in.next();
                }
            }
        }

        try {
            byte sum = calculateByteSum(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка при вычислении суммы: " + e.getMessage());
        }
    }

    public static byte calculateByteSum(byte[] arr) {
        int sum = 0;
        for (byte b : arr) {
            sum += b;
            if (sum > Byte.MAX_VALUE || sum < Byte.MIN_VALUE) {
                throw new ArithmeticException("сумма вышла за границы byte (" + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE + ")");
            }
        }
        return (byte) sum;
    }
}
