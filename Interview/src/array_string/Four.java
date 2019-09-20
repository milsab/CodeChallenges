/*
 * Write a method to decide if two strings are anagrams or not.
 */
package array_string;

//

import java.util.Arrays;

//import java.util.Arrays;

/**
 *
 * @author Milad
 */
public class Four {
    public static void main(String[] args){
        System.out.println(isAnagrams(null, ""));
    }
    
    public static boolean isAnagrams(String str1, String str2){
        if(str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty())
            return false;
        if(str1.length() != str2.length())
            return false;
        
        byte[] char_set1 = new byte[256];
        byte[] char_set2 = new byte[256];
        
        for(int i = 0; i < str1.length(); i++){
            int code = str1.charAt(i);
            char_set1[code]++;
        }
        
        for(int j = 0; j < str2.length(); j++){
            int code = str2.charAt(j);
            char_set2[code]++;
        }
        
        for(int k = 0; k < 256; k++){
            if(char_set1[k] != char_set2[k])
                return false;
        }
        return true;
    }
}
