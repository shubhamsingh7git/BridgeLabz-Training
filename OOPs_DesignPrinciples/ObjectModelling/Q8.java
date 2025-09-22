package OOPs_DesignPrinciples.ObjectModelling;

import java.util.ArrayList;

class Professor {
    String name;

    public Professor(String name) {
        this.name = name;
    }

    public void assignCourse(CourseUni c) {
        c.professor = this;
        System.out.println("Professor " + name + " assigned to course " + c.courseName);
    }
}

class CourseUni {
    String courseName;
    Professor professor;
    ArrayList<StudentUni> students = new ArrayList<>();

    public CourseUni(String courseName) {
        this.courseName = courseName;
    }

    public void enrollStudent(StudentUni s) {
        students.add(s);
        s.addCourse(this);
        System.out.println("Student " + s.name + " enrolled in " + courseName);
    }
}

class StudentUni {
    String name;
    ArrayList<CourseUni> courses = new ArrayList<>();

    public StudentUni(String name) {
        this.name = name;
    }

    public void addCourse(CourseUni c) {
        courses.add(c);
    }
}

public class Q8 {
    public static void main(String[] args) {
        StudentUni s1 = new StudentUni("Shubham");
        StudentUni s2 = new StudentUni("Nitin");

        Professor p1 = new Professor("SatyaPrakash Singh");

        CourseUni c1 = new CourseUni("AI");
        CourseUni c2 = new CourseUni("Data Science");

        p1.assignCourse(c1);

        c1.enrollStudent(s1);
        c2.enrollStudent(s2);
    }
}
