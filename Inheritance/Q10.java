package Inheritance;

public class Q10 {
	static class Person {
	    String name;
	    int id;

	    Person(String name, int id) {
	        this.name = name;
	        this.id = id;
	    }
	}

	interface Worker {
	    void performDuties();
	}

	static class Chef extends Person implements Worker {
	    Chef(String name, int id) {
	        super(name, id);
	    }

	    @Override
	    public void performDuties() {
	        System.out.println("Chef " + name + " (ID: " + id + ") is cooking delicious dishes.");
	    }
	}

	static class Waiter extends Person implements Worker {
	    Waiter(String name, int id) {
	        super(name, id);
	    }

	    @Override
	    public void performDuties() {
	        System.out.println("Waiter " + name + " (ID: " + id + ") is serving food to customers.");
	    }
	}
    public static void main(String[] args) {
        Worker chef = new Chef("Arjun", 101);
        Worker waiter = new Waiter("Ravi", 201);

        chef.performDuties();
        waiter.performDuties();
    }
}
