package dsaPractice;

import java.util.Scanner;

public class q2 {

    public static void rotateArray(int[] nums, int d) {

        int[] temp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            temp[(i+d)%nums.length]=nums[i]; //main shii
        }
        for(int i=0; i<nums.length; i++){
            nums[i]=temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1, 2, 3, 4, 5};
       
        int d = sc.nextInt();
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        rotateArray(nums, d);
        sc.close();
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
}
