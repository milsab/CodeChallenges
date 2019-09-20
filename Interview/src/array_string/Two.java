/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_string;



/**
 *
 * @author Milad
 */
public class Two {
    public static void main(String[] args) {
        System.out.println(reverseString("Milad"));
    }
    
    public static String reverseString(String str){
        String newString = "";
        
        for(int i = str.length() - 1; i >= 0; i--){
            newString = newString + str.charAt(i);
        }
        return newString;
    }
    
     public static String reverseString2(String str){
        
        StringBuilder sb = new StringBuilder(str);
         
        
        
        for(int i = 0; i < str.length() - 1; i++){
            
        }
        return str;
    }
}
