package secondTask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class secondExampleV2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = 0;
        int cols = 0;

        try {

            while (true) {
                System.out.print("Введите количество строк матрицы (> 0): ");
                try {
                    rows = in.nextInt();
                    if (rows > 0) break;
                    else System.out.println("Ошибка: количество строк должно быть больше нуля!");
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введите целое число!");
                    in.next(); // очистка ввода
                }
            }

            while (true) {
                System.out.print("Введите количество столбцов матрицы (> 0): ");
                try {
                    cols = in.nextInt();
                    if (cols > 0) break;
                    else System.out.println("Ошибка: количество столбцов должно быть больше нуля!");
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введите целое число!");
                    in.next(); // очистка ввода
                }
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    while (true) {
                        System.out.print("Элемент [" + i + "][" + j + "]: ");
                        try {
                            matrix[i][j] = in.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Ошибка: введите целое число!");
                            in.next(); // очистка ввода
                        }
                    }
                }
            }

            int columnToPrint;
            while (true) {
                System.out.print("Введите номер столбца для вывода (начиная с 0): ");
                try {
                    columnToPrint = in.nextInt();
                    if (columnToPrint >= 0 && columnToPrint < cols) break;
                    else System.out.println("Ошибка: столбца с таким номером не существует!");
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введите целое число!");
                    in.next(); // очистка ввода
                }
            }

            System.out.println("Столбец " + columnToPrint + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][columnToPrint]);
            }

        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        } finally {
            in.close();
            System.out.println("Программа завершена.");
        }
    }
}