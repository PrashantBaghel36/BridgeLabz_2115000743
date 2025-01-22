public class Earth {
    public static void main(String[] args) {
        
        double radiusInKm = 6378;
        
      
        double pi = Math.PI;
        
      
        double volumeInKm3 = (4.0 / 3.0) * pi * Math.pow(radiusInKm, 3);
        
        
  
        double volumeInMiles3 = volumeInKm3 * 0.239913;
        
       
        System.out.println("The volume of Earth in cubic kilometers is " + volumeInKm3);
        System.out.println("The volume of Earth in cubic miles is " + volumeInMiles3);
    }
}
