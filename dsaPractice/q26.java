package dsaPractice;

import java.util.HashMap;

public class q26 {
    public static int firstUniqueCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(firstUniqueCharacter("leetcode"));      // Output: 0
        System.out.println(firstUniqueCharacter("loveleetcode"));  // Output: 2
        System.out.println(firstUniqueCharacter("aabb"));          // Output: -1
    }
}
