import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem<T, G> {

    private List<T> availableCars;
    private List<G> rentedCars;
    private Scanner scanner;

    public CarRentalSystem() {
        availableCars = new ArrayList<>();
        rentedCars = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addCar(T car) {
        availableCars.add(car);
    }

    public void removeCar(T car) {
        availableCars.remove(car);
        rentedCars.remove(car);
    }

    public void rentCar(T car) {
        if (availableCars.contains(car)) {
            availableCars.remove(car);
            rentedCars.add((G) car);
            System.out.println("Машин түрээслэгдсэн: " + car.toString());
        } else {
            System.out.println("Машиныыг түрээслэх боломжгүй байна: " + car.toString());
        }
    }

    public void returnCar(G car) {
        if (rentedCars.contains(car)) {
            rentedCars.remove(car);
            availableCars.add((T) car);
            System.out.println("Машин буцсан: " + car.toString());
        } else {
            System.out.println("Машин олдсонгүй: " + car.toString());
        }
    }

    public void displayAvailableCars() {
        System.out.println("Боломжит машинууд:");
        for (T car : availableCars) {
            System.out.println(car.toString());
        }
    }

    public void displayRentedCars() {
        System.out.println("Түрээслэгдсэн машинууд:");
        for (G car : rentedCars) {
            System.out.println(car.toString());
        }
    }

    public void displayMenu() {
        System.out.println("\n Цэс:");
        System.out.println("1. Машин нэмэх");
        System.out.println("2. Машин түрээслэх");
        System.out.println("3. Машин буцааж өгөх");
        System.out.println("4. Боломжит машинуудыг харах");
        System.out.println("5. Түрээслэгдсэн машинуудыг харах");
        System.out.println("6. Гарах");
        System.out.print("Сонголтоо оруулна уу: ");
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Нэмэх машиныг оруул: ");
                    addCar((T) scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Түрээслэх машиныг оруулах: ");
                    rentCar((T) scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Буцаах машиныг оруулах: ");
                    returnCar((G) scanner.nextLine());
                    break;
                case 4:
                    displayAvailableCars();
                    break;
                case 5:
                    displayRentedCars();
                    break;
                case 6:
                    System.out.println("Гарж байна...");
                    break;
                default:
                    System.out.println("1-6- ийн хооронд тоо оруул.");
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        CarRentalSystem<String, Integer> carRentalSystem = new CarRentalSystem<>();
        carRentalSystem.run();
    }
}
//
