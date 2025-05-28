package secondTask;
import java.util.InputMismatchException;
import java.util.Scanner;
public class secondExample {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Scanner in = new Scanner(System.in);
        int column;

        while (true) {
            System.out.print("Введите номер столбца (0 до " + (cols - 1) + "): ");
            try {
                column = in.nextInt();
                if (column >= 0 && column < cols) {
                    break;
                } else {
                    throw new IndexOutOfBoundsException("Ошибка: столбца с таким номером не существует!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число!");
                in.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Столбец " + column + ":");
        for (int i = 0; i < rows; i++) {
            System.out.println(matrix[i][column]);
        }
    }
}
