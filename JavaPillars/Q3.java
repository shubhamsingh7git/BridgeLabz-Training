package JavaPillars;
import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: " + rentalRate);
    }
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days; 
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getInsuranceDetails());
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9; 
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getInsuranceDetails());
    }
}


class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; 
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getInsuranceDetails());
    }
}
public class Q3 {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle v1 = new Car("CAR123", 2000, "CAR-INS-001");
        Vehicle v2 = new Bike("BIKE456", 500, "BIKE-INS-002");
        Vehicle v3 = new Truck("TRUCK789", 4000, "TRUCK-INS-003");

        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);

        int rentalDays = 5;
        for (Vehicle v : vehicles) {
            System.out.println(" ");
            v.displayDetails();

            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = 0;

            if (v instanceof Insurable) {
                insuranceCost = ((Insurable) v).calculateInsurance();
            }

            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Payable: " + (rentalCost + insuranceCost));
        }
    }
}
