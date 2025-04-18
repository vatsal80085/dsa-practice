package dsaPractice;

public class q16 {

    public static int countHomogenous(String s){

        int length =1;
        int ans=1;
        char ch = s.charAt(0);
        int m = 1_000_000_007;
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==ch){
                length++;
            }
            else{
                ch=s.charAt(i);
                length=1;
            }
            ans+=length;
            ans%=m;
        }
        return ans%m;
    }
    public static void main(String[] args) {
        String s="abbcccaa";
        System.out.println("Homogenous Substrings Count: " + countHomogenous(s));
    }
}