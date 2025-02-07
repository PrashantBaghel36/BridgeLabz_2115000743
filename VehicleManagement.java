interface Refuelable {
    void refuel();
}
class Vehicle {
    int maxSpeed;
    String model;
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    public void displayVehicleInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
class ElectricVehicle extends Vehicle {
    int batteryCapacity;
    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }
    public void charge() {
        System.out.println("Charging the " + model + "'s battery.");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    double fuelTankCapacity;
    public PetrolVehicle(int maxSpeed, String model, double fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }
    @Override
    public void refuel() {
        System.out.println("Refueling the " + model + " with petrol.");
    }
}
public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle(250, "Tesla Model S", 100);
        PetrolVehicle toyota = new PetrolVehicle(200, "Toyota Camry", 60.0);
        tesla.displayVehicleInfo();
        tesla.charge();
        System.out.println();
        toyota.displayVehicleInfo();
        toyota.refuel();
    }
}
