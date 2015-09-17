/*
 *
 * PalindromeDriver.java
 *
 * The main driver code for lab 1 (asst2).
 * Uses user-defined stack and queue class to determine if
 * input words are palindromes.
 *
 */ 

import java.io.IOException;
import java.util.Scanner;

public class PalindromeDriver {

    /* Main method: reads input and calls palindrome test, prints results */
    public static void main(String[] args) throws IOException
    {
        String[] results;
        int num_phrases;

        Scanner stdin = new Scanner(System.in);
        
        num_phrases = Integer.parseInt(stdin.nextLine());
        results = new String[num_phrases];

        //TODO Write a loop that reads num_phrases input lines from stdin,
        //     and checks whether each line is a palindrome or not.
        //     Use the is_palindrome subroutine to check each line....
        //     you will have to do some preprocessing to the lines first.
        //     Store the results of each line in results array.
        for(int n=0;n<num_phrases;n++){
            if(is_palindrome(stdin.nextLine())) results[n] = "palindrome";
            else results[n] = "not a palindrome";
        }
        
        //TODO Write a loop that iterates through the results array and
        //     prints all the results to stdout.
        for(int i=0;i<num_phrases;i++) System.out.print(results[i] + "\n");
    }

    /* is_palindrome: checks whether input is palindrome, returns true if so,
     *                false otherwise.
     */
    public static boolean is_palindrome(String input) {
        String phrase = input.replaceAll("\\W", "");
        phrase = phrase.toLowerCase();
        Stack s = new Stack();
        Queue q = new Queue();
        int count = 0;
        
        for(int i=0;i<phrase.length();i++) {
            char c = phrase.charAt(i);
            s.push(c);
            q.enqueue(c);
        }
        
        while(!s.isEmpty() && !q.isEmpty()) {
            char x = s.pop();
            char y = q.dequeue();
            if(x!=y) count++;
        }
        
        if(count==0)return true;
        else return false;
    }
}
