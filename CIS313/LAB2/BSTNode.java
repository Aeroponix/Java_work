/*********************************************************
 *		Adam Lindsey				                           *
 *		CIS313 - Fall 2014			                        *
 *		Homework 4 -- Lab 2		                           *
 *		BSTNode.java			                              *
 *********************************************************/

//*NOTE: I prefer a little more functionality in my node class than most...
//       ...this allows me to do more in my BST class with less code.

public class BSTNode {//node for binary search tree
   
   private String data;//holds data for this node
   private BSTNode left,right;//holds left and right node
   
   public BSTNode() { this(null,null,null); }//default constructor
   public BSTNode(String d) { this(d,null,null); }//leaf constructor
   public BSTNode(BSTNode root){this(root.getData(),root.getLeft(),root.getRight());}//copy root constructor
   public BSTNode(BST bt) {this(bt.getRoot());}//copy BST constructor
   public BSTNode(String d, BSTNode l, BSTNode r) {//BSTNode constructor
      this.data = d;
      this.left = l;
      this.right = r;
   }//end BSTNode constructor
   
   public void emptyNode() {
      this.clearData();
      this.clearLeft();
      this.clearRight();
   }
   public boolean isInnerNode() { return left!=null || right!=null; }//is this an inner node?
   public boolean isALeaf() { return left==null && right==null; }//is this a leaf node?
   public boolean hasChildren() { return left!=null && right!=null; }//does this node have 2 children
   public boolean isEmpty() {//is this node empty?
      if(this.data == null) return true;
      else return false;
   }//end isEmpty
   public String getData() {return this.data;}//get data
   public void setData(String d) {this.data = d;}//set data
   public void clearData() {this.data = null;}//clear data
   
   public boolean isLempty() { return left==null; }//is left node empty?
   public BSTNode getLeft() {return this.left;}//get left node
   public void setLeft(BSTNode l) {this.left = l;}//set left node
   public void clearLeft() {this.left = null;}//clear left node
   
   public boolean isRempty() { return right==null; }//is right node empty?
   public BSTNode getRight() {return this.right;}//get right node
   public void setRight(BSTNode r) {this.right = r;}//set right node
   public void clearRight() {this.right = null;}//clear right node
   
   public String toString() { return this.data.toString(); }//local toString() method
   
}//end class BstNode