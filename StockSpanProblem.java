import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpanDays(int[] stocks){
        int n=stocks.length;
        int[] span=new int[n];
        Stack<Integer> s=new Stack<>();
        s.push(0);
        span[0]=1;
        for(int i=1;i<n;i++){
            while(stocks[s.peek()]<=stocks[i] && !s.isEmpty()){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }
           else  span[i]=i-s.peek();
            s.push(i);
        }

        return span;
    }
    public static void main(String[] args) {
       int[] stocks={100,80,60,70,60,75,85};
       int[] span=calculateSpanDays(stocks);
        System.out.println("stock prices: ");
        for(int i=0;i<stocks.length;i++){
            System.out.print(" "+stocks[i]);
        }
        System.out.println();
        System.out.println("span days: ");
        for(int i=0;i<span.length;i++){
            System.out.print(" "+span[i]);
        }
    }
}
