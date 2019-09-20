/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boro_Company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Milad
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(getScore(new ArrayList(Arrays.asList(1, 1, 4, 1, 1))));
//          System.out.println(getScore(new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
          System.out.println(getScore(new ArrayList(Arrays.asList(5, 10, 5, 10, 100, 10, 5, 10, 5, 10, 5, 10))));
    }
    
    public static int getScore(ArrayList<Integer> nums){
        int globalScore = 0;
        
        
        for(int i = 0; i < nums.size(); i++){
            ArrayList<Integer> temp = new ArrayList<>(nums);    
            int index = i;
            int localScore = 0;
            while(!temp.isEmpty()){
                int value = temp.get(index);
                int left = index > 0 ? temp.get(index - 1) : 0;
                int right = index < temp.size() - 1 ? temp.get(index + 1) : 0;
                
                localScore += value;
                temp.remove(index);
                
                ArrayList<Integer> temp2 = new ArrayList<>();
                for(int k = 0; k < temp.size(); k++){
                    if(temp.get(k) != left && temp.get(k) != right)
                        temp2.add(temp.get(k));
                }
                temp = new ArrayList(temp2);
                index = 0;
            }
            globalScore = Math.max(globalScore, localScore);
        }
        return globalScore;
    }
}
