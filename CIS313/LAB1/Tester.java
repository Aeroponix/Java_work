/*
 * Tester.java
 *
 * Written By: Adam Lindsey
 * CIS313 Lab#1 -- Fall 2014
 *
 */


//this main class is just for playing around with some ideas
//and for testing my stack, queue, and scanner classes.

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Tester {
    public static void main(String[] args) throws IOException {
         
         int i = 0;
         Scanner s = new Scanner(System.in);
         
         System.out.println("How many phrases will be tested?\n");
         
         try {
            i = s.nextInt();
         }
         catch(InputMismatchException a) {
            System.out.println("You must enter a number!");
         }
         
         String[] x = new String[i];
         int n = 0;
         
         while(n<i) {
            System.out.print("Phrase " + (n+1) + ": ");
            try{
               x[n] = s.nextLine();
               x[n] = x[n].replaceAll("\\W", "");
               x[n] = x[n].toLowerCase();
            }
            catch(Exception e){
               System.out.print("Something went wrong...");
            }
            n++;
         }
         
         s.close();
         
         Stack st = new Stack();
         Queue qu = new Queue();
         
         for(int num = 0; num<x.length; num++) {
            for(int count = 0; count<x[num].length(); count++) {
               char ch = x[num].charAt(count);
               st.push(ch);
               qu.enqueue(ch);
            }
            
            while(!st.isEmpty()) {
               char ch = st.pop();
               System.out.print(ch);
            }
            
            System.out.print("\n");
            
            while(!qu.isEmpty()) {
               char ch = qu.dequeue();
               System.out.print(ch);
            }
            
            System.out.print("\n");
         }
         
    }
}