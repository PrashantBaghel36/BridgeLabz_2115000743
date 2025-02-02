// Car Rental System: Create a CarRental class with attributes customerName, carModel, and rentalDays. 
// Add constructors to initialize the rental details and calculate total cost.


class CarRental{
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate;
    CarRental(){
        this.customerName = "Unknown";
        this.carModel = "Not Assigned";
        this.rentalDays = 0;
        this.dailyRate = 0;
    }
    CarRental(String customerName, String carModel, int rentalDays, double dailyRate){
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }
    public void totalCost(){
        System.out.println("Customer name: "+customerName);
        System.out.println("Car Model: "+carModel);
        System.out.println("Rental Days: "+rentalDays);
        System.out.println("Dai;y rate: "+dailyRate);
        System.out.println("Total Cost: "+(rentalDays * dailyRate));
    }
}
public class CarRentalSystem {
    public static void main(String[] args) {
        CarRental car1 = new CarRental("Alice Johnson", "Honda Civic", 3, 35.0);
        CarRental car2 = new CarRental("Bob Smith", "Ford Mustang", 7, 60.0);
        CarRental car3 = new CarRental("Charlie Brown", "Tesla Model 3", 2, 80.0);
        System.out.println("-------Car 1------------");
        car1.totalCost();
        System.out.println("-------Car 2------------");
        car2.totalCost();
        System.out.println("-------Car 3------------");
        car3.totalCost();
    }
}
