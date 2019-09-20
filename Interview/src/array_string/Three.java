/*
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer. 
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * FOLLOW UP: Write the test cases for this method.
 */
package array_string;

/**
 *
 * @author Milad
 */
public class Three {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(""));
    }
    
    public static String removeDuplicates(String str){
        if(str == null)
            return "The input string is NULL";
        String newStr = "";
        boolean[] char_set = new boolean[256];
        
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(!char_set[val]){
                char_set[val] = true;
                newStr = newStr + str.charAt(i);
            }
        }
        return newStr;
    }
}