package CodeSignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    String[] allLongestStrings(String[] inputArray) {
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < inputArray.length; i++){
            if(ans.size() == 0 || inputArray[i].length() == ans.get(0).length()){
                ans.add(inputArray[i]);
            } else if(inputArray[i].length() > ans.get(0).length()){
                ans.clear();
                ans.add(inputArray[i]);
            }
        }
        return ans.toArray(new String[]{});
    }

    int commonCharacterCount(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0)
            return 0;

        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();
        int ans = 0;

        for(char c : s1.toCharArray()){
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        for(char c : s2.toCharArray()){
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }

        for(char key : m1.keySet()){
            if(m2.containsKey(key)){
                ans += Math.min(m1.get(key), m2.get(key));
            }
        }
        return ans;
    }
}
