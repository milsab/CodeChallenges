package CodeSignal;

import java.util.*;

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

    int matrixElementsSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(set.contains(j))
                    continue;

                if(matrix[i][j] == 0){
                    set.add(j);
                } else{
                    count += matrix[i][j];
                }
            }
        }
        return count;
    }

    boolean isLucky(int n) {
        if(n <10)
            return false;

        String str = String.valueOf(n);
        int len = str.length();

        String f = str.substring(0, len / 2);
        String s = str.substring(len / 2);

        return getSum(f) == getSum(s);
    }

    int getSum(String s){
        int ans = 0;
        for(char c : s.toCharArray()){
            ans += (c - '0');
        }
        return ans;
    }

    int[] sortByHeight(int[] a) {
        if(a.length == 0)
            return new int[]{};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int x : a){
            if(x != -1)
                minHeap.add(x);
        }

        int[] ans = new int[a.length];
        for(int i = 0; i < a.length; i++){
            if(a[i] == -1)
                ans[i] = -1;
            else{
                ans[i] = minHeap.remove();
            }
        }
        return ans;
    }

    int[] sortByHeight_2(int[] a) {
        int t;
        for(int i=0; i<a.length; i++)
            for(int j=i+1; j<a.length; j++)
                if(a[i]>a[j] && a[i]!=-1 && a[j]!=-1) {

                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
        return a;
    }

}
