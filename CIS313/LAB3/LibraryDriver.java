/******************************************
 *    Adam Lindsey                        *
 *    CIS313 -- Fall 2014                 *
 *    Assignment #6 -- Lab #3             *
 *    LibraryDriver.java                  *
 ******************************************/
 //This is the driver class for the AVLtree/AVLnode

import java.io.IOException;
import java.util.Scanner;

public class LibraryDriver {
   
   public static void main(String[] args) throws IOException {
      AVLtree tree = new AVLtree();
      String[] results;
      int size;
      Scanner stdin = new Scanner(System.in);
      size=Integer.parseInt(stdin.nextLine());
      results = new String[size];
      for(int i=0; i<size; i++) {
         String command = stdin.nextLine().toLowerCase().replaceAll("\\W","");
         String title = stdin.nextLine();
         if("insert".equals(command)){
            tree.insert(title.toLowerCase());
            results[i]= "Inserted " + title + " into the catalog.";
         } else if("find".equals(command)) {
            if(tree.find(title.toLowerCase())) results[i] = title + " is in the catalog.";
            else results[i] = title + " is not in the catalog.";
         } else if("remove".equals(command)) {
            if(tree.remove(title.toLowerCase())) results[i] = title + " was removed from the catalog.";
            else results[i] = title + " is not in the catalog.";
         } else results[i] = command + " -- That command does not exist...";
      }
      for(String result:results) {System.out.print(result + "\n");}
   }
}