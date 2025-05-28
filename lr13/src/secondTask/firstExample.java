package secondTask;
import java.util.InputMismatchException;
import java.util.Scanner;
public class firstExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = 0;
        while (true) {
            System.out.print("Введите размер массива (> 0): ");
            try {
                length = in.nextInt();
                if (length > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: размер должен быть больше нуля!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число!");
                in.next();
            }
        }

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            while (true) {
                System.out.print("Введите элемент " + i + ": ");
                try {
                    arr[i] = in.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введите целое число!");
                    in.next();
                }
            }
        }

        try {
            double average = calculateAverageOfPositive(arr);
            System.out.println("Среднее значение положительных элементов: " + average);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double calculateAverageOfPositive(int[] array) {
        int sum = 0;
        int count = 0;
        for (int num : array) {
            if (num > 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("Ошибка: положительные элементы отсутствуют!");
        }
        return (double) sum / count;
    }
}
