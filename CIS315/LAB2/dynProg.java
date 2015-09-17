/*
 * dynProj.java
 *
 * Written By: Adam Lindsey
 * CIS315 Winter 2015 -- Assignment #6
 *
 */

//gotta have my libraries!
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

//dynProg
public class dynProg {
   public static String thing;
   public static String words[] = new String[58114];
   //main method
   public static void main(String[] args) throws IOException {
      int lines = 0;//the number of lines to be read from an input file
      String line;//variable for each line to be tested
      Scanner s;//scanner class for reading files
      File file;//file class for scanner to scan
      
      //get the file to be tested from the user.
      System.out.println("Please enter the filename of file to test.");//i.e. input.txt or test.txt
      s = new Scanner(System.in);
      
      //try to get input file from user input
      try {
         file = new File(s.nextLine());
         s.close();
         s = new Scanner(file);
         lines = s.nextInt();
         line = s.nextLine();//remove new line character
         for(int x=0;x<lines;x++) {
            int temp = x + 1;
            System.out.println("\nphrase number: " + temp);
            line = s.nextLine();
            line = line.trim();
            System.out.println(line + "\n");
            
            System.out.println("iterative attempt: ");
            if(split_iterative(line)) {
               System.out.println("YES, can be split");
               System.out.println(thing);
            }
            else System.out.println("NO, cannot be split");
            System.out.println("\nmemoized attempt:");
            if(split_recursive(line)) {
               System.out.println("YES, can be split");
               print_recursive(line);
            }
            else System.out.println("NO, cannot be split");
         }
         s.close();
      } catch(FileNotFoundException a) {
         System.out.println("Filename must exist and be formatted with respect to this folder!");   
      } catch(InputMismatchException a) {
         System.out.println("First line of file must be number of lines to test!");
      } catch(Exception a) {
         System.out.println("Something went wrong... please try again!");
      }
   }//end main
   
   //dictionary method
   //checks to see if input string is a word
   public static boolean dict(String word) {
      //dictionary file
      File diction = new File("diction10k.txt");
      //Scanner element for grabbing words
      Scanner f;
      try {//exception handling
         if(words[0]==null) {
            f = new Scanner(diction);
            int count = 0;
            while(f.hasNextLine()){
               String thing = f.nextLine();//get next word in dictionary
               thing = thing.trim();//clean the next word in dictionary
               words[count] = thing;
               /*if(thing.equals(word)) {
                  f.close();//no longer need to scan dictionary
                  return true;//input string is a word
               }//end if*/
               count++;
            }//end while
            Arrays.sort(words);
         }//end if
         int index = Arrays.binarySearch(words, word);
         index = index >= 0 ? index : -1;
         if(index>-1)return true;
      } catch(FileNotFoundException ex) {
         System.out.println("diction10k.txt file not found!");
      } catch(Exception e) {
         System.out.println("dict(word) function did not work... try again!");
      }//end try
      return false;//input string is not a word
   }//end dict method
   
   //iterative split method
   public static boolean split_iterative(String s) {
      thing="";
      String temp_s = s;
      int n = temp_s.length();
      for(int i=1; i<=n; i++) {
         if(dict(temp_s)) {
            thing += temp_s;
            return true;
         }
         if(dict(temp_s.substring(0,n-i))) {
            thing+=temp_s.substring(0,n-i) + " ";
            temp_s = temp_s.substring(n-i,n);
            n=temp_s.length();
            i=1;
         }
      }
      return false;//default
   }//end iterative split
   
   //recursive split method
   public static boolean split_recursive(String s) {
      if(dict(s))return true;
      int n = s.length();
      for(int i=1; i<n; i++) {
         if(dict(s.substring(0,n-i)))
            return split_recursive(s.substring(n-i, n));
      }
      return false;
   }//end recursive split
   
   //recursive print method
   public static void print_recursive(String s) {
      if(dict(s)) {
         System.out.print(s + "\n");
         return;
      }
      int n = s.length();
      for(int i=1; i<n; i++) {
         if(dict(s.substring(0,n-i))) {
            System.out.print(s.substring(0,n-i) + " ");
            print_recursive(s.substring(n-i, n));
            break;
         }
      }
   }//end of recursive print
}


