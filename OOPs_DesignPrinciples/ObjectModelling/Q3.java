package OOPs_DesignPrinciples.ObjectModelling;

import java.util.ArrayList;

class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public void showEmployee() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    String deptName;
    ArrayList<Employee> employees = new ArrayList<>();

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void showDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.showEmployee();
        }
    }
}

class Company {
    String companyName;
    ArrayList<Department> departments = new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    public void showCompany() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.showDepartment();
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        Company comp = new Company("TechCorp");

        Department d1 = new Department("IT");
        d1.addEmployee(new Employee("Alice"));
        d1.addEmployee(new Employee("Bob"));

        Department d2 = new Department("HR");
        d2.addEmployee(new Employee("Charlie"));

        comp.addDepartment(d1);
        comp.addDepartment(d2);

        comp.showCompany();
    }
}
