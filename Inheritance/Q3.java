package Inheritance;

public class Q3 {

    static class Vehicle {
        double maxSpeed;
        String fuelType;

        Vehicle(double maxSpeed, String fuelType) {
            this.maxSpeed = maxSpeed;
            this.fuelType = fuelType;
        }

        void displayInfo() {
            System.out.println("Max Speed: " + maxSpeed);
            System.out.println("Fuel Type: " + fuelType);
        }
    }

    static class Car extends Vehicle {
        int seatCapacity;

        Car(double maxSpeed, String fuelType, int seatCapacity) {
            super(maxSpeed, fuelType);
            this.seatCapacity = seatCapacity;
        }

        void displayInfo() {
            super.displayInfo();
            System.out.println("Seat Capacity: " + seatCapacity);
        }
    }

    static class Truck extends Vehicle {
        int cargoCapacity;

        Truck(double maxSpeed, String fuelType, int cargoCapacity) {
            super(maxSpeed, fuelType);
            this.cargoCapacity = cargoCapacity;
        }

        void displayInfo() {
            super.displayInfo();
            System.out.println("Cargo Capacity: " + cargoCapacity);
        }
    }

    static class Motorcycle extends Vehicle {
        int model;

        Motorcycle(double maxSpeed, String fuelType, int model) {
            super(maxSpeed, fuelType);
            this.model = model;
        }

        void displayInfo() {
            super.displayInfo();
            System.out.println("Model: " + model);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Car(180, "Petrol", 5);
        Vehicle v2 = new Truck(120, "Diesel", 10000);
        Vehicle v3 = new Motorcycle(150, "Petrol", 2023);

        v1.displayInfo();
        System.out.println();
        v2.displayInfo();
        System.out.println();
        v3.displayInfo();
        System.out.println();
    }
}