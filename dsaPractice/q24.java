package dsaPractice;

public class q24 {
    
    public static void reverseStrings(String[] s){
        String temp[]= new String[s.length];
        for(int i=0; i<s.length;i++){
            temp[i]=s[s.length-i-1];
        }
        for(int j=0; j<s.length;j++){
            s[j]=temp[j];
        }
    }
    public static void main(String[] args) {
        String[] s = {"apple", "banana", "cherry", "date"};

        System.out.println("Before reversal:");
        for (String str : s) {
            System.out.print(str + " ");
        }

        reverseStrings(s);

        System.out.println("\nAfter reversal:");
        for (String str : s) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

}
