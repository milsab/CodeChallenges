
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClosestTime {

    public static void main(String[] args) {
//        System.out.println(nextClosestTime("11:11"));
//        System.out.println(recursiveReverse("milad"));
//        generate(3);

//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1, 1);
//        map.put(2, 2);
//        map.put(3, 3);
////        Integer i = new Integer(10);
////        Integer j = new Integer(20);
////        swap(i, j);
////        System.out.println("i = " + i + ", j = " + j);
//        System.out.println(map.entrySet());
//        changeMap(map);
//        System.out.println(map.entrySet());

//          int[] result = searchRange(new int[]{2,4}, 99);
//          
//          System.out.println("[" + result[0] + ", " + result[1] + "]");
          
//          System.out.println(thirdSmallest(new HashSet(Arrays.asList(2,4,7,3,9,1))));
          
//          System.out.println(sockMerchant(6, new int[]{2,5,5,1,2,3,5}));
          
          System.out.println(isPalindrome(123));
    }

    public static void changeMap(HashMap map) {
        HashMap<Integer, Integer> insideMap = new HashMap<>();
        insideMap.put(1, 1000);
        insideMap.put(2, 2000);
        insideMap.put(3, 3000);
        map = insideMap;
        map.put(1, 10);
        System.out.println(map.entrySet());
    }

    public static void swap(int i, int j) {
//        Integer temp = new Integer(i);
        j = 40;
        i = 1;
//        j = temp;
        System.out.println("i = " + i + ", j = " + j);
    }

    public static String nextClosestTime(String time) {
        if (time == null || time.equals("")) {
            return "";
        }
        HashSet<Integer> set = new HashSet<>();

        for (String s : time.split("")) {
            if (s.equals(":")) {
                continue;
            }
            set.add(Integer.parseInt(s));
        }

        String[] digits = time.split(":"); // digit[0] -> HH
        int h = Integer.parseInt(digits[0]);
        int m = Integer.parseInt(digits[1]);

        while (h <= 23) {
            System.out.println("outer h:" + h);
            if (!set.contains(h % 10) || !set.contains(h / 10)) {
                h++;
                continue;
            }
            while (++m <= 59) {
                if (!set.contains(m % 10) || !set.contains(m / 10)) {
                    System.out.println(makeTime(h, m));
                    continue;
                }

//                System.out.println("makeTime(h, m)");
                return makeTime(h, m);
            }
            m = 0;
            System.out.println("h:" + h);
            if (++h == 24) {
                h = 0;
            }
        }
        return time;
    }

    public static String makeTime(int h, int m) {
        String HH = String.valueOf(h);
        String MM = String.valueOf(m);
        if (HH.length() == 1) {
            HH = "0" + HH;
        }
        if (MM.length() == 1) {
            MM = "0" + MM;
        }
        return HH + ":" + MM;
    }

    // Reverse String using Recursion
    public static String recursiveReverse(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return str.charAt(str.length() - 1)
                + recursiveReverse(str.substring(0, str.length() - 1));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);

        for (int i = 1; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    // Binary Search Approach
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[]{-1, -1};
        
        // find the leftmost index
        while (left <= right) {
            System.out.println(left + " " + right);
            int mid = left + (right - left) / 2;
            System.out.println("mid:  " + mid);
            if ((nums[mid] == target && mid == 0) || 
                    (nums[mid] == target && nums[mid - 1] != target)) {
                result[0] = mid;
                break;
            } else if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result[0]);
        // find the rightmost index
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ( (nums[mid] == target && mid == nums.length - 1) || 
                    (nums[mid] == target && nums[mid + 1] != target)) {
                result[1] = mid;
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    public static int thirdSmallest(Set<Integer> nums){
        int size = nums.size();
        
        Integer[] arr2 = nums.toArray(new Integer[] {});
        
        if(size < 3) return 0;
        int[] arr = new int[size];
        int index = 0;
        for(int num : nums){
            arr[index] = num;
            index++;
        }
        
        Arrays.sort(arr);
        
        return arr[2];
    }
    
    public static int sockMerchant(int n, int[] ar) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int c : ar){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int result = 0;

        for(int k : map.keySet()){
            result += map.get(k) / 2;
        }

        return result;

    }
    
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        String s = sb.toString();
        String reverse = sb.reverse().toString();
        
        System.out.println("s: " + s);
        System.out.println("reverse: " + reverse);
        return s.equals(reverse);
    }
}
