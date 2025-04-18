package dsaPractice;
import java.util.Scanner;
public class q51 {
    // bar chart question

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }

        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max, arr[i]);
        }

        for (int floor = max; floor>=1; floor--) {
            
            for(int i=0; i<arr.length; i++){
                if(arr[i]>=floor){
                    System.out.print("*\t");
                }   
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}