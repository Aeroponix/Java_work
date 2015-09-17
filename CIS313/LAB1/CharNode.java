/*
 * CharNode.java
 *
 * Written By: Adam Lindsey
 * CIS313 Lab#1 -- Fall 2014
 *
 */

public class CharNode{//char node for linked list action
   
   private char data; //holds data for this node
   private CharNode next; // holds the next node
   
   public CharNode(){ }//default constructor
   public CharNode(char x) { this.data = x; }//constructor that sets data only
   public CharNode(char x, CharNode y) {
      //constructor that sets data and next node
      this.data = x;
      this.next = y;
   }
   
   public char getData() { return data; }//get the char in node
   public void setData(char d) { data = d; }//set the char in node
   
   public CharNode getNext() { return next; }//get the next node
   public void setNext(CharNode n) { next = n;} //set the next node
   
}