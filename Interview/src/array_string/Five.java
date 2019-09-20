/*
 * Write a method to replace all spaces in a string with ‘%20’.
 */
package array_string;

/**
 *
 * @author Milad
 */
public class Five {
    public static void main(String[] args){
        System.out.println(replaceSpace("  "));
    }
    
    public static String replaceSpace(String str){
        if(str == null || str == "")
            return "Invalid Input";
        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                newStr = newStr + "%20";
                continue;
            }
            newStr = newStr + str.charAt(i);
        }
        return newStr;
    }
}
