package linkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Chalenge {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<Integer>(2);
        result.add(0, 0);
        result.add(1, 0);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                result.set(0, result.get(0) + 1);
            } else if (a.get(i) < b.get(i)) {
                result.set(1, result.get(1) + 1);
            } else if (a.get(i) == b.get(i)) {
                result.set(0, result.get(0) + 1);
                result.set(1, result.get(1) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        int[] arr = {55, 48, 48,45, 91, 97, 45, 1, 39, 54,36, 6, 19, 35, 66, 36 ,72, 93, 38, 21, 65, 70, 36, 63, 39, 76, 82, 26, 67, 29, 24, 82, 62, 53, 1, 50, 47, 65, 67, 19, 66, 90, 77};
//        plusMinus(arr);
        long[] arr = {256741038L , 623958417L, 467905213L , 714532089L , 938071625L};
//        int[] arr = {3, 1, 4, 5, 2};
        miniMaxSum(arr);
    }

    static void miniMaxSum(long[] arr) {
        int low = 0;
        int high = arr.length;
        quickSort(arr, low, high - 1);
        long minSum = sum(arr, low, high - 1);
        long maxSum = sum(arr, low + 1, high);
        System.out.println(minSum);
        System.out.println(maxSum);

    }

    static long sum(long[] arr, int low, int high) {
        long sum = 0;
        for (int i = low; i < high; i++) {
            sum = arr[i];
        }
        return sum;
    }

    static long[] quickSort(long arr[], int low, int high) {
        long[] sortArr = arr;
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
            
            
        }
        return sortArr;
    }

    static int partition(long arr[], int low, int high) {
        long pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s < n - i; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    static void plusMinus(int[] arr) {

        double n = arr.length;
        double positive = 0;
        double negative = 0;
        double zero = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                negative++;
            } else if (arr[i] > 0) {
                positive++;
            } else if (arr[i] == 0) {
                zero++;
            }
        }
        System.out.println("N: " + n);
        System.out.println("Positive: " + positive);
        System.out.println("Negative: " + negative);
        System.out.println("Zero: " + zero);

//        double d = positive / n;
//        String str2 = String.format("My answer is %.8f", d);
//        System.out.println( str2 );
        if ((positive / n) == 1) {
            System.out.println(String.format("%.6f", 1f));
        } else {
            System.out.println(String.format("%.6f", (positive / n) % 1));
        }
        System.out.println(String.format("%.6f", (positive / n) % 1));
        System.out.println(String.format("%.6f", (negative / n) % 1));
        System.out.println(String.format("%.6f", (zero / n) % 1));

    }
}
