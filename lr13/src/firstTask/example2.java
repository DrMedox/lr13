package firstTask;

public class example2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (RuntimeException e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}

