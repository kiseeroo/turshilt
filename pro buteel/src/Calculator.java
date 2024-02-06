import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       

        System.out.println("Эхний тоогоо оруулна уу:");
        double num1 = scanner.nextDouble();

        System.out.println("Дараагийн тоог оруулга уу:");
        double num2 = scanner.nextDouble();

        System.out.println("Үйлдлээ сонгоно уу:");
        System.out.println("1. Нэмэх (+)");
        System.out.println("2. Хасах (-)");
        System.out.println("3. Үржүүлэх (*)");
        System.out.println("4. Хуваах (/)");
        System.out.println("5. Квадрат (^)");
        System.out.println("6. Үлдэгдэлтэй хуваах (%)");

        int choice = scanner.nextInt();
        double result = 0;

        switch (choice) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 != 0)
                    result = num1 / num2;
                else
                    System.out.println("0т хувааж болохгүй!");
                break;
            case 5:
                result = Math.pow(num1, num2);
                break;
            case 6:
                result = num1 % num2;
                break;
            default:
                System.out.println("Буруу сонголт!");
        }

        System.out.println("Үр дүн\r: " + result);
    }
}


