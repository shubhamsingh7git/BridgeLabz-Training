package JavaPillars;
import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    protected void setRatePerKm(double ratePerKm) { this.ratePerKm = ratePerKm; }
    protected void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }

    public String getCurrentLocation() { return currentLocation; }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    public abstract double calculateFare(double distance);
}


class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50;
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// Subclass: Bike
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// Subclass: Auto
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20;
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

public class Q8 {

    public static void calculateFares(List<Vehicle> vehicles, double distance) {
        for (Vehicle v : vehicles) {
            System.out.println(" ");
            v.getVehicleDetails();
            System.out.println("Distance: " + distance + " km");
            System.out.println("Fare: " + v.calculateFare(distance));
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR001", "Alice", 15, "Downtown"));
        vehicles.add(new Bike("BIKE002", "Bob", 10, "Uptown"));
        vehicles.add(new Auto("AUTO003", "Charlie", 8, "Central Market"));

        double distance = 12.5;
        calculateFares(vehicles, distance);

        System.out.println("\nUpdating locations...");
        Map<String, String> newLocations = new HashMap<>();
        newLocations.put("CAR001", "Airport");
        newLocations.put("BIKE002", "Mall");
        newLocations.put("AUTO003", "Train Station");

        for (Vehicle v : vehicles) {
            ((GPS) v).updateLocation(newLocations.get(v.getVehicleId()));
        }

        System.out.println("\nUpdated Vehicle Details:");
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
        }
    }
}
