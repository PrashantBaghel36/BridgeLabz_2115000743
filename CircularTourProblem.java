public class CircularTourProblem {
    public static int check(int[] petrol,int[] distance){
        int extra=0,required=0;
        int start=0;
        for(int i=0;i< petrol.length;i++){
            extra+=petrol[i]-distance[i];
            if(extra<0){
                start=i+1;
                required+=extra;
                extra=0;
            }
        }
        if(required<extra) return start;
        return -1;
    }
    public static void main(String[] args) {
        int[] petrol = {7,8,5,11,7,6};
        int[] distance = {6,7,8,9,7,5};
        int startingPoint=check(petrol,distance);
        if(startingPoint!=-1) System.out.println("Starting point: "+startingPoint);
        else System.out.println("No posible starting point");
    }
}
