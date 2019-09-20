import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    public static void main(String [] args){
        countVowels("Milad Sabouri");
    }

    public static void countVowels(String str){
        List<String> vowels = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
        String[] letters = str.toLowerCase().split("");
        int vowelsCounts = 0;
        int constantCounts = 0;
        for(String s : letters){
            if(s.equals(" ")){
                continue;
            }
            else if (vowels.contains(s)){
                vowelsCounts++;
            } else {
                constantCounts++;
            }
        }
        System.out.println("Vowels: " + vowelsCounts + " Constants: " + constantCounts);
    }
}

