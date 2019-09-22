package CodeSignal;

import java.util.ArrayList;
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
}
