package dsaPractice;

public class q25 {

    public static boolean isVowel(char ch){
        if(ch=='a' ||ch=='e'||ch=='i' ||ch=='o'||ch=='u' ||ch=='A'||ch=='E' ||ch=='I'||ch=='O' ||ch=='U'){
            return true;
        }
        return false;
    }
    public static String reverseVowels(String s){
        
        char[] schar=s.toCharArray();
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(!isVowel(schar[start])){
                start++;
            }
            else if(!isVowel(schar[end])){
                end--;
            }
            else{
                char temp = schar[start];
                schar[start]=schar[end];
                schar[end]=temp;
                start++;
                end--;
            }
        }
        return new String(schar);
    }
    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s)); // Expected output: "AceCreIm"
    }
}
