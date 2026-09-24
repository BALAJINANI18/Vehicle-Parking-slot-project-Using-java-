import java.util.Scanner;

interface Parking {

    void park();

    void remove();
}

abstract class Vehicle {

    private String vehicleNumber;
    private String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    abstract void vehicleType();
}


class Car extends Vehicle implements Parking {

    Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    void vehicleType() {
        System.out.println("Vehicle Type : Car");
    }

    public void park() {
        System.out.println("Car parked successfully!");
    }

    public void remove() {
        System.out.println("Car removed successfully!");
    }
}


class Bike extends Vehicle implements Parking {

    Bike(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    void vehicleType() {
        System.out.println("Vehicle Type : Bike");
    }

    public void park() {
        System.out.println("Bike parked successfully!");
    }

    public void remove() {
        System.out.println("Bike removed successfully!");
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Vehicle[] slots = new Vehicle[10];

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("     PARKING SLOT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. View Parking Slots");
            System.out.println("4. Search Vehicle");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();


            // PARK VEHICLE
            if (choice == 1) {

                System.out.println("\n--- PARK VEHICLE ---");

                System.out.print("Enter vehicle number: ");
                String number = sc.nextLine();

                System.out.print("Enter owner name: ");
                String owner = sc.nextLine();

                System.out.println("\n1. Car");
                System.out.println("2. Bike");

                System.out.print("Enter vehicle type: ");
                int type = sc.nextInt();

                Vehicle vehicle;

                if (type == 1) {

                    vehicle = new Car(number, owner);

                } else {

                    vehicle = new Bike(number, owner);
                }


                boolean parked = false;

                for (int i = 0; i < slots.length; i++) {

                    if (slots[i] == null) {

                        slots[i] = vehicle;

                        System.out.println(
                                "\nVehicle parked successfully!"
                        );

                        System.out.println(
                                "Slot Number : " + (i + 1)
                        );

                        vehicle.vehicleType();

                        parked = true;

                        break;
                    }
                }

                if (!parked) {

                    System.out.println(
                            "\nSorry! Parking is full."
                    );
                }
            }

            else if (choice == 2) {

                System.out.println("\n--- REMOVE VEHICLE ---");

                System.out.print(
                        "Enter vehicle number: "
                );

                String number = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < slots.length; i++) {

                    if (slots[i] != null &&
                            slots[i].getVehicleNumber()
                                    .equalsIgnoreCase(number)) {

                        slots[i] = null;

                        System.out.println(
                                "Vehicle removed successfully!"
                        );

                        System.out.println(
                                "Slot " + (i + 1) +
                                        " is now available."
                        );

                        found = true;

                        break;
                    }
                }

                if (!found) {

                    System.out.println(
                            "Vehicle not found!"
                    );
                }
            }


            else if (choice == 3) {

                System.out.println(
                        "\n------ PARKING SLOTS ------"
                );

                for (int i = 0; i < slots.length; i++) {

                    if (slots[i] == null) {

                        System.out.println(
                                "Slot " + (i + 1) +
                                        " : Empty"
                        );

                    } else {

                        System.out.println(
                                "Slot " + (i + 1) +
                                        " : " +
                                        slots[i].getVehicleNumber()
                        );
                    }
                }
            }


            else if (choice == 4) {

                System.out.print(
                        "\nEnter vehicle number: "
                );

                String number = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < slots.length; i++) {

                    if (slots[i] != null &&
                            slots[i].getVehicleNumber()
                                    .equalsIgnoreCase(number)) {

                        System.out.println(
                                "\nVehicle Found!"
                        );

                        System.out.println(
                                "Vehicle Number : " +
                                        slots[i].getVehicleNumber()
                        );

                        System.out.println(
                                "Owner Name     : " +
                                        slots[i].getOwnerName()
                        );

                        System.out.println(
                                "Slot Number    : " +
                                        (i + 1)
                        );

                        slots[i].vehicleType();

                        found = true;

                        break;
                    }
                }

                if (!found) {

                    System.out.println(
                            "Vehicle not found!"
                    );
                }
            }


            else if (choice == 5) {

                System.out.println(
                        "\nThank you for using Parking Slot System!"
                );
            }


            else {

                System.out.println(
                        "Invalid choice!"
                );
            }

        } while (choice != 5);

        sc.close();
    }
}