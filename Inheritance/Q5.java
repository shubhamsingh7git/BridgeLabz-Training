package Inheritance;
class Device {
    String deviceId;
    String status; 

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    double temperatureSetting;


    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status); 
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus(); 
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}


public class Q5 {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat(
            "T1001",
            "ON",
            24.5
        );

       
        thermostat.displayStatus();
    }
}
