package dsaPractice;

import java.util.*;
public class q14 {

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] chars= s.toCharArray();
        char[] chart= t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}