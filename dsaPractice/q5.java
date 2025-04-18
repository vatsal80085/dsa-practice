package dsaPractice;

public class q5 {
    public static int majorityElement(int nums[]){
        int count=0;
        Integer candidate=null;
        for(int num: nums){
            if(count==0){
                candidate=num;
            }
            count += (num==candidate)?1:-1;
            if(count>=nums.length/3){
                return candidate;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 3, 4, 2, 3, 3, 3};

        System.out.println("Majority Element: " + majorityElement(arr));

        int arr2[] = {1, 2, 3, 4, 5};
        System.out.println("Majority Element: " + majorityElement(arr2));
    }
}
