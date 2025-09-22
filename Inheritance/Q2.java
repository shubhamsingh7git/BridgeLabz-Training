package Inheritance;

public class Q2 {
    static class Employee {
        String name;
        int id;
        double salary;

        Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        void Details() {
            System.out.println("Name: " + name);
            System.out.println("Id: " + id);
            System.out.println("Salary: " + salary);
        }
    }

    static class Manager extends Employee {
        int teamsize;

        Manager(String name, int id, double salary, int teamsize) {
            super(name, id, salary);
            this.teamsize = teamsize;
        }

        @Override
        void Details() {
            super.Details();
            System.out.println("Team Size: " + teamsize);
        }
    }

    static class Developer extends Employee {
        String language;

        Developer(String name, int id, double salary, String language) {
            super(name, id, salary);
            this.language = language;
        }

        @Override
        void Details() {
            super.Details();
            System.out.println("Programming Language: " + language);
        }
    }

    static class Intern extends Employee {
        int duration;

        Intern(String name, int id, double salary, int duration) {
            super(name, id, salary);
            this.duration = duration;
        }

        @Override
        void Details() {
            super.Details();
            System.out.println("Internship Duration: " + duration + " months");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Manager("Sarthak", 153, 5000000.0, 2);
        Employee e2 = new Developer("Shubham", 100, 10000000.0, "Java");
        Employee e3 = new Intern("Nitin", 201, 145345.0, 6);

        e1.Details();
        System.out.println();
        e2.Details();
        System.out.println();
        e3.Details();
    }
}







