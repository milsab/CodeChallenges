/*
* This question was asked in my interview on Thursday, 27 Sep, 2018, on IIT Campus
* aaaabbCdd3 ==> a4bbCdd3
 */
package GrubHub;

import java.util.List;

/**
 *
 * @author Milad
 */
public class GrubHubInterview {

    public static void main(String[] args) {

        System.out.println(makeMP3("aaaabbCdd3"));

    }

    public static String makeMP3(String str) {
        char[] input = str.toCharArray();
        char flag = input[0];
        int counter = 1;
        String result = "";
        for (int i = 1; i < input.length; i++) {
            if (input[i] == flag) {
                counter++;
            } else {
                switch (counter) {
                    case 1:
                        result = result + flag;
                        break;
                    case 2:
                        result = result + flag + flag;
                        break;
                    default:
                        result = result + flag + counter;
                        break;
                }
                counter = 1;
                flag = input[i];
            }

        }
        switch (counter) {
            case 1:
                return result + flag;
            case 2:
                return result + flag + flag;
            default:
                return result + flag + counter;
        }
    }
}
