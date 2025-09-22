package OOPs_DesignPrinciples.ObjectModelling;

import java.util.ArrayList;

class Course {
    String courseName;
    ArrayList<Student> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void enrollStudent(Student s) {
        students.add(s);
        s.addCourse(this);
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void showCourses() {
        System.out.println("Student: " + name + " enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class School {
    String schoolName;
    ArrayList<Student> students = new ArrayList<>();

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void showSchool() {
        System.out.println("School: " + schoolName);
        for (Student s : students) {
            System.out.println("Student: " + s.name);
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        school.addStudent(s1);
        school.addStudent(s2);

        c1.enrollStudent(s1);
        c2.enrollStudent(s1);
        c2.enrollStudent(s2);

        school.showSchool();
        s1.showCourses();
        s2.showCourses();
        c2.showEnrolledStudents();
    }
}
