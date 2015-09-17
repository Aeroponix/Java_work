/*
 * Queue.java
 *
 * Written By: Adam Lindsey
 * CIS313 Lab#1 -- Fall 2014
 *
 */
 
public class Queue {

   private CharNode front = null; //front of the queue
   private CharNode back = null;  //back of the queue
   
   public Queue() { } //default constructor
   
   public void enqueue(char data) {//add item to queue
      CharNode node = new CharNode(data, null);
      if(isEmpty()) { front = node; }
      else { back.setNext(node); }
      back = node;
   }
   
   public char dequeue() {//remove item from queue
      if(!isEmpty()) {
         char x = this.front();
         if(back == front) back = null;
         front = front.getNext();
         return x;
      } else return ' ';
   }
   
   public char front() {//what is in the front?
      return front.getData();
   }
   
   public int size() {
      int i = 0; //counter
      //increment counter for each node
      for(CharNode node = front; node != null; node = node.getNext()) {i++;}
      return i; //return counter
   }
   
   public boolean isEmpty() { return front == null; } //is the queue empty?
   
}