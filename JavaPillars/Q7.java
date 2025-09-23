package JavaPillars;
import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private List<String> medicalHistory;

    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = new ArrayList<>();
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    protected String getDiagnosis() { return diagnosis; }
    protected void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    protected List<String> getMedicalHistory() { return medicalHistory; }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        getMedicalHistory().add(record);
    }

    @Override
    public List<String> viewRecords() {
        return getMedicalHistory();
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Patient Type: In-Patient");
        System.out.println("Days Admitted: " + daysAdmitted);
        System.out.println("Daily Rate: " + dailyRate);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        getMedicalHistory().add(record);
    }

    @Override
    public List<String> viewRecords() {
        return getMedicalHistory();
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Patient Type: Out-Patient");
        System.out.println("Consultation Fee: " + consultationFee);
    }
}

public class Q7 {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient p1 = new InPatient(101, "Alice", 30, "Flu", 5, 2000);
        p1.addRecord("Admitted for high fever.");
        p1.addRecord("Prescribed antibiotics.");

        OutPatient p2 = new OutPatient(102, "Bob", 40, "Back Pain", 500);
        p2.addRecord("Consulted for chronic back pain.");
        p2.addRecord("Prescribed physiotherapy.");

        patients.add(p1);
        patients.add(p2);

        for (Patient patient : patients) {
            System.out.println(" ");
            patient.getPatientDetails();
            System.out.println("Diagnosis: " + patient.getDiagnosis());

            if (patient instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) patient;
                System.out.println("Medical Records: " + mr.viewRecords());
            } else {
                System.out.println("Medical Records: N/A");
            }

            System.out.println("Bill Amount: " + patient.calculateBill());
        }
    }
}
