import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarParkingSystem {

    private List<String> availableSpaces;
    private List<Integer> bookedSpaces;
    private Scanner scanner;

    public CarParkingSystem() {
        availableSpaces = new ArrayList<>();
        bookedSpaces = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addSpace(String space) {
        availableSpaces.add(space);
    }

    public void removeSpace(String space) {
        int index = availableSpaces.indexOf(space);
        if (index != -1) {
            availableSpaces.remove(index);
            bookedSpaces.remove(index);
        }
    }

    public void bookSpace(String space) {
        if (availableSpaces.contains(space)) {
            availableSpaces.remove(space);
            bookedSpaces.add(Integer.parseInt(space));
            System.out.println("Зогсоолын зай " + space + " амжилттай захиалагдлаа.");
        } else {
            System.out.println("Зогсоолын зай " + space + " захиалагдсангүй.");
        }
    }

    public void returnSpace(int space) {
        if (bookedSpaces.contains(space)) {
            bookedSpaces.remove(Integer.valueOf(space));
            availableSpaces.add(String.valueOf(space));
            System.out.println("Зогсоол " + space + " буцаагдлаа.");
        } else {
            System.out.println("Зогсоол " + space + " бүртгэгдсэнгүй.");
        }
    }

    public void displayAvailableSpaces() {
        System.out.println("Зогсоол зай харах:");
        for (String space : availableSpaces) {
            System.out.println(space);
        }
    }

    public void displayBookedSpaces() {
        System.out.println("Захиалагдсан зогсоол харах:");
        for (Integer space : bookedSpaces) {
            System.out.println(space);
        }
    }

    public void displayMenu() {
        System.out.println("\nЦэс:");
        System.out.println("1. Зогсоол нэмэх");
        System.out.println("2. Зогсоол Захиалах");
        System.out.println("3. Зогсоолоос гарах");
        System.out.println("4. Зогсоол зай харах");
        System.out.println("5. Захиалагдсан зогсоол харах");
        System.out.println("6. Гарах");
        System.out.print("Сонголт оруулах: ");
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Зогсоолын дугаар нэмэх: ");
                    addSpace(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Захиалах зогсоолын дугаар: ");
                    bookSpace(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Гарах машины зогсоолын дугаар: ");
                    returnSpace(Integer.parseInt(scanner.nextLine()));
                    break;
                case 4:
                    displayAvailableSpaces();
                    break;
                case 5:
                    displayBookedSpaces();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("1-6 Сонголтоо хийнэ үү.");
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        CarParkingSystem parkingSystem = new CarParkingSystem();
        parkingSystem.run();
    }
}
