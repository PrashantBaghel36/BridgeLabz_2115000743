// Create a Vehicle class to manage the details of vehicles:
// Instance Variables: ownerName, vehicleType.
// Class Variable: registrationFee (fixed for all vehicles).
// Methods:
// An instance method displayVehicleDetails() to display owner and vehicle details.
// A class method updateRegistrationFee() to change the registration fee.


class Vehicle{
    String ownerName;
    String vehicleType;
    static int registrationFee = 300;
    Vehicle(String ownerName, String vehicleType){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails(){
        System.out.println("Owner is: "+ownerName);
        System.out.println("Vehicle Type: "+vehicleType);
        System.out.println("Registration Fee: "+registrationFee);
    }
    static void updateRegistrationFee(int registrationFee){
        Vehicle.registrationFee = registrationFee;
    }

}

public class VehicleRegistration {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Shailendra", "Car");
        Vehicle vehicle2 = new Vehicle("Rahul", "Bike");
        Vehicle vehicle3 = new Vehicle("Prashant", "Bus");
        System.out.println("----------------Vehicle 1 details--------------------");
        vehicle1.displayVehicleDetails();
        System.out.println("----------------Vehicle 2 details--------------------");
        vehicle2.displayVehicleDetails();
        System.out.println("----------------Vehicle 3 details--------------------");
        vehicle3.displayVehicleDetails();

        System.out.println("------Updating registration fee from 300 to 500-------");
        Vehicle.updateRegistrationFee(500);
        vehicle2.displayVehicleDetails();
    }
}
