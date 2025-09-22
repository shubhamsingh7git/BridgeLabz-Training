package OOPs_DesignPrinciples.ObjectModelling;

import java.util.ArrayList;

class Faculty {
    String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void showFaculty() {
        System.out.println("Faculty: " + name);
    }
}

class DepartmentUni {
    String deptName;

    public DepartmentUni(String deptName) {
        this.deptName = deptName;
    }

    public void showDepartment() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    String name;
    ArrayList<DepartmentUni> departments = new ArrayList<>();
    ArrayList<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addDepartment(DepartmentUni d) {
        departments.add(d);
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public void showUniversity() {
        System.out.println("University: " + name);
        for (DepartmentUni d : departments) {
            d.showDepartment();
        }
        for (Faculty f : faculties) {
            f.showFaculty();
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        University uni = new University("Tech University");

        DepartmentUni d1 = new DepartmentUni("Computer Science");
        DepartmentUni d2 = new DepartmentUni("Physics");

        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Dr. Johnson");

        uni.addDepartment(d1);
        uni.addDepartment(d2);

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.showUniversity();
    }
}
