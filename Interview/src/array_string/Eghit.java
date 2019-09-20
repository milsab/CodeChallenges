/*
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (i.e., "waterbottle" is a rotation of "erbottlewat").
 */
package array_string;

/**
 *
 * @author Milad
 */
public class Eghit {
    public static void main(String[] args){
        System.out.println(isRotate("milad sabouri", "ad sabouri"));
    }
    
    public static boolean isRotate(String str1, String str2){
        String con = str1 + str1;
        if(con.contains(str2))
            return true;
        else
            return false;
    }
}
