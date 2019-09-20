/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Milad
 */
public class Auth {

    public static void main(String[] args) {

        String[] logs = {
            "1 Auth 20",
            "2 Auth 15",
            "3 Auth 10",
            "3 Sale 12",
            "3 Capture 5",
            "4 Auth 5",
            "1 Auth 5",
            "5 Sale 7",
            "1 Capture 0",
            "4 Capture 0",
            "2 Capture 15",
            "1 Sale 3",
            "1 Capture 18"
        };

        System.out.println(validCloseout(logs));
    }

    public static class Payment {

        private String action;
        private int val;

        public Payment() {

        }

        public Payment(String action, int val) {
            this.action = action;
            this.val = val;
        }

        public String getAction() {
            return action;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

    }

    public static boolean validCloseout(String[] logs) {

        HashMap<Integer, Queue<Payment>> qMap = new HashMap<>();
        HashMap<Integer, Stack<Payment>> sMap = new HashMap<>();
        
        List<Payment>[] list = new ArrayList[3];

        for (String log : logs) {
            String[] str = log.split(" ");
            int id = Integer.parseInt(str[0]);
            String action = str[1];
            int val = Integer.parseInt(str[2]);
            Payment payment = new Payment(action, val);

            if (!qMap.containsKey(id)) {
                qMap.put(id, new LinkedList<Payment>());
            }

            qMap.get(id).add(payment);
        }

        for (int key : qMap.keySet()) {
            Queue<Payment> q = qMap.get(key);

            while (!q.isEmpty()) {
                Payment payment = q.poll();

                if (payment.getAction().equals("Auth")) {

                    if (!sMap.containsKey(key)) {
                        sMap.put(key, new Stack<Payment>());
                    }
                    sMap.get(key).add(payment);

                } else if (payment.getAction().equals("Capture")) {

                    int val = payment.getVal();
                    if (payment.getVal() > sMap.get(key).peek().getVal()) {
                        return false;
                    }

                } else if (payment.getAction().equals("Sale")) {

                }
            }
        }
        return true;
    }
    
    
}
