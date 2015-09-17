/*********************************************************
 *		Adam Lindsey				                           *
 *		CIS313 - Fall 2014			                        *
 *		Homework 4 -- Lab 2		                           *
 *		LibraryDriver.java			                        *
 *********************************************************/

import java.io.IOException;
import java.util.Scanner;
 
public class LibraryDriver {

      public static BST bt;
      
      public static void main(String[] args) throws IOException {
         
         bt = new BST();//instantiate the binary tree
         
         String[] results;//store results to be returned
         int size;//stores array size
         
         Scanner stdin = new Scanner(System.in);//instantiate scanner
         size = Integer.parseInt(stdin.nextLine());//get # of operations
         
         results = new String[size];//allocate array based on # of operations
         
         for(int i = 0; i < size; i++) {
            
            String command = stdin.nextLine().toLowerCase().replaceAll("\\W", "");//command
            String title = stdin.nextLine();//value
            
            if("insert".equals(command)) {
               
               bt.insert(title.toLowerCase());
               results[i] = "Inserted " + title + " into the catalog.";
               
            } else if("find".equals(command)) {
            
               BSTNode node;
               node = bt.find(title.toLowerCase());
               if(node!=null) results[i] = title + " is in the catalog.";
               else results[i] = title + " is not in the catalog.";
               
            } else if("remove".equals(command)) {
               
               boolean result = bt.remove(title.toLowerCase());
               if(result) results[i] = title + " was removed from the catalog.";
               else results[i] = title + " is not in the catalog.";
               
            } else {//if a command isn't recognized.
               results[i] = command + " -- That command does not exist!";
            }
            
         }//end for loop
         
         for(String result:results) {System.out.print(result + "\n");}//loop through results and print
         
      }//end main method
      
}//end class LibraryDriver