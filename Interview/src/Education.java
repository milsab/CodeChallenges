
//import com.sun.deploy.util.ArrayUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.util.*;

import static javafx.scene.input.KeyCode.T;

/**
 * @author Milad
 */
public class Education {

    public static void main(String[] args) throws Exception {
//        chunkArray(new Integer[]{1,2,3,4,5,6,7,8,9,10},3);
//        isAnagram2("hel lo", "l!!lohe");
//        fibo(39);
//        int[] result = selectionSort(new int[]{2,7,4,1,9,8,6});
//        int[] result = QuickSort(new int[]{1, 2, 7, 4, 1, 9, 8, 6, 4}, 0, 8);
        int[] result = compress(new int[]{100,20, 22, 30});
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + ", ");
//        }
    }
//        System.out.print(Arrays.toString(result));
        

//        checkPrime(2, 3, 4, 6, 7, 8, 9);
//        makeMP3_correct("aabbbBBcaaa");
    }

    // Scanner
    public void readScanner() {
        Scanner scan = new Scanner(System.in);
        String mys = scan.nextLine();
        System.err.println(mys);
    }

    // printf formating
    public void formatting() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            // Left justify ==> -
            // Right justify ==> default
            // Zero padding ==> 0
            System.out.printf("%-15s%03d\n", s1, x);
        }
    }

    // Calendar
    public static void findDay(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        System.out.println(cal.getDisplayName(cal.DAY_OF_WEEK,
                Calendar.LONG, new Locale("en", "US")).toUpperCase());

    }

    // Currency Format
    public static void currencyFormat() {
        Locale enLocale = new Locale("en", "US");
        Locale frLocale = new Locale("fr", "FR");
        Locale chLocale = new Locale("zh", "CN");
        Locale inLocale = new Locale("en", "IN");

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(enLocale);
        System.out.println(numberFormat.format(100.76));

        numberFormat = NumberFormat.getCurrencyInstance(frLocale);
        System.out.println(numberFormat.format(100.76));

        numberFormat = NumberFormat.getCurrencyInstance(chLocale);
        System.out.println(numberFormat.format(100.76));

        numberFormat = NumberFormat.getCurrencyInstance(inLocale);
        System.out.println(numberFormat.format(100.76));

    }

    // Substring & Capitalize Letters & ...
    public static void manipulateString() {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        // Tatal length of two strings
        System.out.println(A.length() + B.length());

        // *IMPORTANT*: Determine if A is lexicographically larger than B ( B does  come before A in the dictionary)?
        System.out.println(A.charAt(0) > B.charAt(0) ? "Yes" : "No");

        // Capitalize first letters of each word
        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " "
                + B.substring(0, 1).toUpperCase() + B.substring(1));
    }

    // MD5
    public static void md5Hash() throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(str.getBytes());

        // Convert byte array into signum representation 
        BigInteger no = new BigInteger(1, b);

        // Convert message digest into hex value 
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        System.out.println(hashtext);
    }

    // SHA-256
    public static void getSha256() throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] b = sha.digest(str.getBytes());

        BigInteger no = new BigInteger(1, b);
        String hashtext = no.toString(16);
        while (hashtext.length() < 64) {
            hashtext = "0" + hashtext;
        }
        System.out.println(hashtext);
    }

    // Substring
    public static void getSubstring() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        List<String> list = new ArrayList<>();
        for (int i = 0; i <= str.length() - 3; i++) {
            list.add(str.substring(i, i + 3));
        }
        for (String l : list) {
            System.out.println(l);
        }
        Collections.sort(list);
        System.out.println("After Sort");
        for (String l : list) {
            System.out.println(l);
        }
    }

    //  Palindrome: Java String Reverse (palindrome, ex: madam -> reverse: madam)
    public static void palindrom() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        // Using StringBuilder ** Very Interesting **
        System.out.println(str.equals(new StringBuilder(str).reverse().toString())
                ? "Yes" : "No");

        // Using STACK
        String newStr = "";
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.empty()) {
            newStr += stack.pop();
        }

        if (str.equals(newStr)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // Anagram --> First Solution: Sort arrays
    public static void isAnagram() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        if (s1.length() != s2.length()) {
            System.out.println("Not Anagram");
            return;
        }

        char[] char_s1 = s1.toLowerCase().toCharArray();
        char[] char_s2 = s2.toLowerCase().toCharArray();

        java.util.Arrays.sort(char_s1);
        java.util.Arrays.sort(char_s2);

        System.out.println(char_s1);
        System.out.println(char_s2);
        System.out.println((new String(char_s1)).equals(new String(char_s2))
                ? "Anagram" : "Not Anagram");
    }

    // Anagram --> First Solution(Alternative): Sort arrays
    public static void isAnagramAl() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        if (s1.length() != s2.length()) {
            System.out.println("Not Anagram");
            return;
        }

        String[] str1 = s1.toLowerCase().split("");
        String[] str2 = s2.toLowerCase().split("");

        java.util.Arrays.sort(str1);
        java.util.Arrays.sort(str2);

        System.out.println(
                String.join("", str1).equals(String.join("", str2)) ? "Anagram" : "Not Anagram"
        );
    }

    // Anagram --> Second Solution: HashMap
    public static void isAnagram2(String str1, String str2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        str1 = str1.replaceAll("[^\\w]", "");
        str2 = str2.replaceAll("[^\\w]", "");
        for (String s : str1.split("")) {
            map1.put(s, map1.get(s) == null ? 1 : map1.get(s) + 1);
        }
        for (String s : str2.split("")) {
            map2.put(s, map2.get(s) == null ? 1 : map2.get(s) + 1);
        }
        if (map1.size() != map2.size() || !map1.keySet().equals(map2.keySet())) {
            System.out.println("Not Anagram 1");
            return;
        }
        for (String s : map1.keySet()) {
            if (map1.get(s) != map2.get(s)) {
                System.out.println("Not Anagram 3");
                return;
            }
        }
        System.out.println("Anagram");
    }

    // BigInteger
    public static void bigInteger() {
        Scanner sc = new Scanner(System.in);
        BigInteger N = new BigInteger(sc.next());
        BigInteger M = new BigInteger(sc.next());
        sc.close();

        System.out.println(N.add(M));
        System.out.println(N.multiply(M));
    }

    // BigInteger isProbablePrime
    public static void isPrime() {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        sc.close();

        BigInteger N = new BigInteger(n);

        if (N.isProbablePrime(1)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }

    // Sort BigDecimal
    public static void sortBD() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                BigDecimal S1 = new BigDecimal(s1);
                BigDecimal S2 = new BigDecimal(s2);
                return S2.compareTo(S1);
            }
        });

        for (String str : s) {
            System.out.println(str);
        }
    }

    // String Split
    public static void splitString() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        if (s == null || "".equals(s.trim())) {
            System.out.println("0");
            return;
        }

        String[] out = s.trim().split("[ !,?._'@]+");
        System.out.println(out.length);
        for (String str : out) {
            System.out.println(str);
        }

        scan.close();
    }

    // REGEX (username -> start with alphanumeric character and contains only 
    // alphanumeric characters and underscore. It has to have at least 8 and at most 30 Characters
    public static void testREGEX() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String userName = scan.nextLine();
            if (userName.matches("^[A-Za-z]\\w{7,29}")) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }

    // REGEX (IP Address)
    public static void RegexIP() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String IP = scan.next();
            //https://www.hackerrank.com/challenges/java-regex/forum
            String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
            String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

            System.out.println(IP.matches(pattern));
        }
    }

    public static void test() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int b = scan.nextInt();
            a[i] = b;
        }
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // List
    public static void list() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Integer> list = new ArrayList<Integer>();

        while (n-- > 0) {
            list.add(in.nextInt());
        }

        int q = in.nextInt();
        while (q-- > 0) {
            String query = in.next();
            if (query.equals("Insert")) {
                list.add(in.nextInt(), in.nextInt());
            } else if (query.equals("Delete")) {
                list.remove(in.nextInt());
            }
        }
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    // HashMap
    public static void hashmap() {
        HashMap<String, Integer> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            map.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String name = in.nextLine();
            if (map.get(name) != null) {
                System.out.println(name + "=" + map.get(name));
            } else {
                System.out.println("Not found");
            }
        }
    }

    // HashMap & ArrayList
    public static void arrayHash() {
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= line; i++) {
            int n = in.nextInt();
            if (n == 0) {
                continue;
            }
            ArrayList<Integer> array = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                array.add(j, in.nextInt());
            }
            map.put(i, array);
        }
        for (Integer key : map.keySet()) {
            System.out.print(key + ": ");
            for (Integer i : map.get(key)) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            try {
                System.out.println(map.get(in.nextInt()).get(in.nextInt() - 1));
            } catch (Exception ex) {
                System.out.println("ERROR");
            }
        }
    }

    // BitSet
    public static void bitset() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String operator = in.next();
            switch (operator) {
                case "AND":
                    if (in.nextInt() == 1) {
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    System.out.println(b1);
                    System.out.println(b2);
                    in.nextInt();
                    break;
                case "SET":
                    if (in.nextInt() == 1) {
                        b1.set(in.nextInt());
                    } else {
                        b2.set(in.nextInt());
                    }
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    System.out.println(b1);
                    System.out.println(b2);
                    break;
                case "FLIP":
                    if (in.nextInt() == 1) {
                        b1.flip(in.nextInt());
                    } else {
                        b2.flip(in.nextInt());
                    }
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    break;
                case "OR":
                    if (in.nextInt() == 1) {
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    System.out.println(b1);
                    System.out.println(b2);
                    in.nextInt();
                    break;
                case "XOR":
                    if (in.nextInt() == 1) {
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                    System.out.println(b1);
                    System.out.println(b2);
                    in.nextInt();
                    break;
            }
        }
    }

    // Stack --> (){[()]} --> TRUE
    public static void stack() {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        loop:
        while (sc.hasNext()) {
            String input = sc.next();
            stack.clear();
            for (int i = 0; i < input.length(); i++) {
                Character ch = input.charAt(i);
                switch (ch) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(ch);
                        break;
                    case ')':
                        if (stack.isEmpty() || '(' != stack.pop()) {
                            System.out.println("flase");
                            continue loop;
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || '[' != stack.pop()) {
                            System.out.println("flase");
                            continue loop;
                        }
                        break;
                    case '}':
                        if (stack.isEmpty() || '{' != stack.pop()) {
                            System.out.println("flase");
                            continue loop;
                        }
                        break;
                    case 't':
                        System.out.println("Program Terminated!");
                        break loop;
                }
            }
            if (stack.isEmpty()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

    //Reverse String
    public static void reverseString(String str) {

        // ** 1st Soulution (Using StringBuilder)
//        String s = new StringBuilder(str).reverse().toString();
//        System.out.println(s);
        // ** 2nd Solution
//        String reverse = "";
//        for(String ss : str.split("")){
//            reverse = ss + reverse;
//        }
//        System.out.println(reverse);
        // ** 3th Solution (Reduce function)        
        Optional<String> sss = Arrays.stream(str.split(""))
                .reduce(
                        (accumulator, element) -> element + accumulator
                );
        System.out.println(sss.get());
    }

    // Start Comparator
    class Checker implements Comparator<Player> {

        public int compare(Player p1, Player p2) {

            if (p1.score == p2.score) {
                return p1.name.compareTo(p2.name);
            } else {
                if (p1.score > p2.score) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    class Player {

        int score;
        String name;

        public Player(int score, String name) {
            this.score = score;
            this.name = name;
        }

    }

    // END Comparator
    // Found Number of Characters on a String
    public static void numStr(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : str.split("")) {
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        int max = 0;
        String ch = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                ch = key;
            }
            System.out.println(key + " " + map.get(key));
        }
        System.out.println("Max Key: " + ch + " " + "Max No: " + max);
    }

    public static void makeMP3(String str) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (String s : str.split("")) {
            System.out.println(s);
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
            System.out.println(s + " " + map.get(s));
        }
        System.out.println(map);

        String mp3 = "";

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
            mp3 += key + (map.get(key) == 1 ? "" : map.get(key));

        }
        System.out.println(mp3);
    }

    public static void makeMP3_correct(String str) {
        String MP3 = "";
        String currentLetter = "";
        String[] arr = str.split("");
        String letter = arr[0];
        int counter = 1;

        for (int i = 1; i < arr.length; i++) {
            currentLetter = arr[i];
            if (!currentLetter.equals(letter) || i == arr.length - 1) {
                switch (counter) {
                    case 1:
                        MP3 += letter;
                        break;
                    case 2:
                        MP3 += letter + letter;
                        break;
                    default:
                        MP3 += letter + counter;
                        break;
                }
                letter = currentLetter;
                counter = 1;
            } else {
                counter++;
            }
        }
        System.out.println(MP3);
    }

    // Deque
    public static void deque() {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (i > m) {
                max = (set.size() > max) ? set.size() : max;
                Object first = deque.getFirst();
                deque.removeFirst();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }

            int num = in.nextInt();
            deque.addLast(num);
            set.add(num);
        }
        if (n == m) {
            max = set.size();
        }
        System.out.println(max);
    }

    // Chunked Array
    public static void chunkArray(Integer[] array, int size) {
        List<List<Integer>> bigArray = new ArrayList<>();
        List<Integer> subArray = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            if (flag == size) {
                bigArray.add(subArray);
                subArray = new ArrayList<>();
                flag = 0;
            }
            subArray.add(array[i]);
            flag++;
        }
        bigArray.add(subArray);
        System.out.println(bigArray);
    }

    //Capitalize first word in a string
    public static void CapitalizeStr(String str) {
        List<String> result = new ArrayList<>();
        for (String s : str.split(" ")) {
            result.add((s.substring(0, 1).toUpperCase() + s.substring(1)));
        }
        System.out.println(String.join(" ", result));
    }

    //Creating Stairs
    public static void stairs(int n) {
        for (int row = 0; row < n; row++) {
            String line = "";
            for (int column = 0; column < n; column++) {
                if (column <= row) {
                    line += "#";
                } else {
                    line += " ";
                }
            }
            System.out.println(line);
        }
    }

    // Creating Stairs using RECURSIVE approach
    public static void recursiveStairs(int n) {
        if (n == 1) {
            System.out.println("#");
        } else {
            recursiveStairs(n - 1);
            for (int i = 0; i < n; i++) {
                System.out.print("#");
            }
        }
    }

    // Find vowels in the string --> Iterative Approach
    public static void findVowels1(String str) {
        List<String> vowels = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
        String v = "aeiou";
        int count = 0;
        for (String s : str.toLowerCase().split("")) {
            if (vowels.contains(s)) {
                count++;
            }
        }
        System.out.println(count);
    }

    // Find vowels in the string --> RegExp Approach
    public static void findVowels2(String str) {
        int count = 0;
        for (String s : str.toLowerCase().split("")) {
            if (s.matches("[aeiou]")) {
                count++;
            }
        }
        System.out.println(count);
    }

    //Fibonaci Series --> Iteration Approach
    public static void fibo(int n) {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 2; i <= n; i++) {
            result.add(result.get(i - 1) + result.get(i - 2));
        }
        System.out.println(result.get(n));
    }

    //Fibonaci Series --> Recursive Approach
    public static int fiboRec(int n) {
        if (n < 2) {
            return n;
        }
        return fiboRec(n - 1) + fiboRec(n - 2);
    }

    // Implementing Queue with 2 Stacks
    public static void QueueFromStack() {
        QueueFromStack queue = new QueueFromStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());

    }

    //find the MidPoint of a LinkedList
    public static void midPoint(LinkedList<Integer> list) {
    }

    public static boolean sameFrequency(int a, int b) {
        String[] s1 = String.valueOf(a).split("");
        String[] s2 = String.valueOf(b).split("");

        if (s1.length != s2.length) {
            return false;
        }

        Arrays.sort(s1);
        Arrays.sort(s2);

        String fs1 = "";
        for (String s : s1) {
            fs1 += s;
        }

        String fs2 = "";
        for (String s : s2) {
            fs2 += s;
        }

        if (fs1.equals(fs2)) {
            return true;
        }
        return false;
    }

    public static boolean sameFrequency2(int a, int b) {
        String[] s1 = String.valueOf(a).split("");
        String[] s2 = String.valueOf(b).split("");

        if (s1.length != s2.length) {
            return false;
        }

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (String s : s1) {
            map1.put(s, map1.containsKey(s) ? map1.get(s) + 1 : 1);
        }

        for (String s : s2) {
            map2.put(s, map2.containsKey(s) ? map2.get(s) + 1 : 1);
        }

        for (String key : map1.keySet()) {
            if (map1.get(key) != map2.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static boolean averagePair(Integer[] arr, Double avg) {
        Integer firstIndex = 0;
        Integer endIndex = arr.length - 1;

        while (firstIndex < endIndex) {
            double a = (arr[firstIndex] + arr[endIndex]) / 2.0;
            if (a == avg) {
                return true;
            }
            if (a > avg) {
                endIndex--;
            } else {
                firstIndex++;
            }
        }
        return false;
    }

    public static boolean isSubsequence(String s1, String s2) {
        if (s1 == "") {
            return true;
        }
        int i = 0, j = 0;

        while (j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            if (i == s1.length()) {
                return true;
            }
            j++;
        }
        return false;
    }

    public static int factorial(int f) {
        if (f <= 1) {
            return 1;
        }
        return f * factorial(f - 1);
    }

    public static int productOfArray(int[] arr) {

        List<Integer> arrayList = new ArrayList(Arrays.asList(arr));
        if (arrayList.size() == 1) {
            return arrayList.get(0);
        }
        //FALSE*****************************************************************
        return arrayList.remove(arrayList.size() - 1) * productOfArray(arr);
    }

    //Print Prime Numbers
    public static void checkPrime(int... args) {

        next:
        for (int a : args) {
            int p = a / 2;
            for (int i = 2; i <= p; i++) {
                if ((a % i) == 0) {
                    continue next;
                }
            }
            System.out.println(a);
        }
    }

    //Binary Search
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int rigth = arr.length - 1;

        while (left < rigth) {
            int mid = (int) Math.floor((left + rigth) / 2);
            if (arr[mid] == value) {
                return mid;
            }

            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                rigth = mid - 1;
            }
        }
        return -1;
    }

    // Naive Search: find the number of short string happens in long string
    public static int naiveSearch(String longStr, String shortStr) {
        int count = 0;
        for (int i = 0; i < longStr.length(); i++) {
            for (int j = 0; j < shortStr.length(); j++) {
                if (longStr.charAt(i + j) != shortStr.charAt(j)) {
                    break;
                }
                if (j == shortStr.length() - 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            if (i != indexOfMin) {
                int temp = arr[indexOfMin];
                arr[indexOfMin] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    // Return the M-th lowest number from an array using BubbleSort Approach (N^2)
    public static int getMThMin(int[] arr, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr[m - 1];
    }

    // Return the M-th smallest number from an array using QuickSort Approach
    public static int getMthMinQS(int[] arr, int m) {
        return 0;
    }

    public static int[] QuickSort(int[] arr, int start, int end) {

        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            QuickSort(arr, start, pivotIndex - 1);
            QuickSort(arr, pivotIndex + 1, end);
        }
        return arr;
    }

    // Pick the pivot in the leftmost element of the array
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pivotIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivot) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }
        swap(arr, start, pivotIndex);
        return pivotIndex;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void test2() {
        Integer[] arr = new Integer[]{3, 4, 1, 2};
//        ArrayList<Integer> list = new ArrayList<Integer>( Arrays.asList(arr));
//        Collections.sort(list);
    }

    public static void rotate(int[] nums, int k) {
        int[] newArr = new int[nums.length];

        int index = nums.length - k;

        int j = 0;
        for (int i = index; i < nums.length; i++) {
            newArr[j] = nums[i];
            j++;
        }

        for (int i = 0; i < k; i++) {
            newArr[j] = nums[i];
            j++;
        }

        nums = newArr;

        for (int i : newArr) {
            System.out.print(i + " ");
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        Integer s = map.values().stream().filter(x -> x == 1).findFirst().get();
        System.out.println(s);
        return 9;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        Queue<List<TreeNode>> q = new LinkedList<>();

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        q.add(nodeList);

        while (q.size() > 0) {
            nodeList = q.poll();
            List<TreeNode> childList = new ArrayList<>();
            for (TreeNode node : nodeList) {
                innerList.add(node.val);
                if (node.left != null) {
                    childList.add(node.left);
                }
                if (node.right != null) {
                    childList.add(node.right);
                }
            }

            list.add(innerList);

            nodeList.clear();
            nodeList = childList;
            q.add(nodeList);
        }
        return list;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sumAround2DArray(int[][] arr, int row, int col) {
        return inArray(arr, row, col + 1)
                + inArray(arr, row, col - 1)
                + inArray(arr, row - 1, col)
                + inArray(arr, row + 1, col);
    }

    // Helper method for sumAround2DArray
    public static int inArray(int[][] arr, int row, int col) {
        if (row >= 0 && row < arr.length
                && col >= 0 && col < arr[0].length) {
            return arr[row][col];
        }
        return 0;
    }

    public static int[] compress(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int index = map.get(nums[i]);  //index = 0;
            result[index] = i + 1;
        }

        return result;
    }

}
