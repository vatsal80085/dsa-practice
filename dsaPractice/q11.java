package dsaPractice;

public class q11 {
    public static boolean isPalindrome(String s){
        String words = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int left =0;
        int right=words.length()-1;
        while(left<=right){
            if(words.charAt(right)!=words.charAt(left)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome("")); // true
    }
}
