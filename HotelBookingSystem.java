// Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights. 
//Use default, parameterized, and copy constructors to initialize bookings.


class HotelBooking{
    String guestName;
    String roomType;
    int nights;
    // Default Constructor
    HotelBooking(){
        guestName = "No Guest yet";
        roomType = "Not occupied yet";
        nights = 0;
    }
    // Parameterized Constructor
    HotelBooking(String guestName, String roomType, int nights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    HotelBooking(HotelBooking ref){
        guestName = ref.guestName;
        roomType = ref.roomType;
        nights = ref.nights;
    }
    public void displayBookings(){
        System.out.println("Guest name is: "+guestName);
        System.out.println("Room type is: "+roomType);
        System.out.println("The number of nights are: "+nights);
    }
}
public class HotelBookingSystem{
    public static void main(String[] args) {
        HotelBooking def = new HotelBooking();
        System.out.println("Bookings from default constructor:");
        def.displayBookings();
        System.out.println("\n\nBookings from parameterized constructor:");
        HotelBooking para = new HotelBooking("Shailendra", "AC", 2);
        para.displayBookings();
        System.out.println("\n\nBookings from copy constructor:");
        HotelBooking copy = new HotelBooking(para);
        copy.displayBookings();
        
    }
}