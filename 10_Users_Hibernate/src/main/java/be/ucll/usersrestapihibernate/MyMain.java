package be.ucll.usersrestapihibernate;

public class MyMain {
    public static void main(String[] args) {
        class Vehicle {
            private int wheels;

            public Vehicle(int wheels) {
                this.wheels = wheels;
            }

            public String showInfo() {
                return "This vehicle has " + wheels + " wheels.";
            }
        }

        class Car extends Vehicle {
            private int fuel;

            public Car(int wheels, int fuel) {
                super(wheels);
                this.fuel = fuel;
            }

            public String showInfo() {
                return "This is a Car. " + super.showInfo();
            }
        }

        Car car = new Car(4, 6);
        System.out.println(car.showInfo());
    }
}
