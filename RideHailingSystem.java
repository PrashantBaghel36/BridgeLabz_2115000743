abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private Vehicle next;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    public Vehicle getNext() {
        return next;
    }

    public void setNext(Vehicle next) {
        this.next = next;
    }
}

interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

public class RideHailingSystem {
    public static void main(String[] args) {
        Car car = new Car("C001", "John Doe", 15);
        Bike bike = new Bike("B002", "Jane Smith", 10);
        Auto auto = new Auto("A003", "Mike Johnson", 12);

        car.setNext(bike);
        bike.setNext(auto);

        double distance = 10;

        Vehicle current = car;
        while (current != null) {
            System.out.println(current.getVehicleDetails());
            System.out.println("Fare for " + distance + " km: " + current.calculateFare(distance));
            if (current instanceof GPS) {
                GPS gpsVehicle = (GPS) current;
                gpsVehicle.updateLocation("Downtown");
                System.out.println("Updated Location: " + gpsVehicle.getCurrentLocation());
            }
            System.out.println("----------------------------");
            current = current.getNext();
        }
    }
}
