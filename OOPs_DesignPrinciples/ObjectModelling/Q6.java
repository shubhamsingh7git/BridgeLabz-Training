package OOPs_DesignPrinciples.ObjectModelling;

import java.util.ArrayList;

class Patient {
    String name;

    public Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    ArrayList<Patient> patients = new ArrayList<>();

    public Doctor(String name) {
        this.name = name;
    }

    public void consult(Patient p) {
        patients.add(p);
        System.out.println("Doctor " + name + " consulted patient " + p.name);
    }
}

class Hospital {
    String hospitalName;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}

public class Q6 {
    public static void main(String[] args) {
        Hospital h1 = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dr. Alice");
        Doctor d2 = new Doctor("Dr. Bob");

        Patient p1 = new Patient("John");
        Patient p2 = new Patient("Emma");

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
    }
}
