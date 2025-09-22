package Inheritance;

public class Q1 {
    static class Animal {
        String name;
        int age;

        Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void makesound() {
            System.out.println("Animal make a sound");
        }
    }

    static class Dog extends Animal {
        Dog(String name, int age) {
            super(name, age);
        }

        void makesound() {
            System.out.println("Dog make a sound");
        }
    }

    static class Cat extends Animal {
        Cat(String name, int age) {
            super(name, age);
        }

        void makesound() {
            System.out.println("Cat make a sound");
        }
    }

    static class Bird extends Animal {
        Bird(String name, int age) {
            super(name, age);
        }

        void makesound() {
            System.out.println("Bird make a sound");
        }
    }

    public static void main(String[] args) {
        Animal a1 = new Dog("Pit bull", 3);
        Animal a2 = new Cat("Luccy", 2);
        Animal a3 = new Bird("Parrot", 1);

        a1.makesound();
        a2.makesound();
        a3.makesound();
    }
}