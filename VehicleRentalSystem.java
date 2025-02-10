abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private Vehicle next;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public Vehicle getNext() {
        return next;
    }

    public void setNext(Vehicle next) {
        this.next = next;
    }
}

interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Applied";
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9;
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Applied";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car = new Car("CAR123", 50, "CAR-INS-001");
        Bike bike = new Bike("BIKE456", 20);
        Truck truck = new Truck("TRUCK789", 100, "TRUCK-INS-002");

        car.setNext(bike);
        bike.setNext(truck);

        int rentalDays = 5;

        Vehicle current = car;
        while (current != null) {
            double rentalCost = current.calculateRentalCost(rentalDays);
            System.out.println("Vehicle Number: " + current.getVehicleNumber());
            System.out.println("Type: " + current.getType());
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);

            if (current instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) current;
                System.out.println("Insurance Cost: " + insurableVehicle.calculateInsurance());
                System.out.println(insurableVehicle.getInsuranceDetails());
            }
            System.out.println("----------------------------");
            current = current.getNext();
        }
    }
}
