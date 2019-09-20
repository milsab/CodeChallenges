/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

import java.math.BigDecimal;

/**
 *
 * @author Milad
 */
public class Test {
    public static void main(String[] args){
        double a = 0.2;
        double b = 0.3;
        System.out.println(b -a);
        
        Double _a = new Double("0.2");
        Double _b = new Double("0.3");
        System.out.println(_b - _a);
        
        BigDecimal aa = new BigDecimal("0.2");
        BigDecimal bb = new BigDecimal("0.3");
        System.out.println(bb.subtract(aa));
    }
}
