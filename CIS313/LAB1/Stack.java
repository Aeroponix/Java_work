/*
 * Stack.java
 *
 * Written By: Adam Lindsey
 * CIS313 Lab#1 -- Fall 2014
 *
 */

public class Stack {
   
   private CharNode top = null; //the top of the stack
   
   public Stack() { } //default constructor
   
   public void push(char data) { top = new CharNode(data, top);}
   
   public char pop() {
      char x = top();
      top = top.getNext();
      return x;
   }
   
   public char top() {//if not empty get data
      if(!isEmpty()) return top.getData(); 
      else return ' ';
   }
   
   public int size() {
      int i = 0; //store the count
      //increment the counter for each node in the stack
      for(CharNode node = top; node!=null; node = node.getNext()) {i++;}
      return i; //return the count
   }
   
   public boolean isEmpty() { return top == null; } //is the stack empty?

}