/******************************************
 *    Adam Lindsey                        *
 *    CIS313 -- Fall 2014                 *
 *    Assignment #6 -- Lab #3             *
 *    AVLnode.java                        *
 ******************************************/
 //This is the node class for the AVLtree class.
 
public class AVLnode {
   
   //local variables
   int      height;//height of this node
   String   data;//contents of this node
   AVLnode  left;//left child node
   AVLnode  right;//right child node
   
   //constructors
   public AVLnode() { this("",null,null); }
   public AVLnode(String s) { this(s,null,null); }
   public AVLnode(AVLnode n) { this(n.data,n.left,n.right); }
   public AVLnode(String s, AVLnode l, AVLnode r) {
      this.data = s;
      this.left = l;
      this.right = r;
      height = 0;
   }
   
   //The method pile...
   public void incHeight() {this.height++;}//increment height
   public void decHeight() {this.height--;}//decrement height
   //and all the rest are get and set methods.
   public int getHeight() {return this.height;}
   public void setHeight(int x) {height = x;}
   public String getData() {return this.data;}
   public void setData(String s) {this.data = s;}
   public AVLnode getLeft() {return this.left;}
   public void setLeft(AVLnode n) {this.left = n;}
   public AVLnode getRight() {return right;} 
   public void setRight(AVLnode n) {this.right = n;}

}//end of AVLnode class