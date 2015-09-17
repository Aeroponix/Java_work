/*********************************************************
 *		Adam Lindsey				                           *
 *		CIS313 - Fall 2014			                        *
 *		Homework 4 -- Lab 2		                           *
 *		BST.java			                                    *
 *********************************************************/
//This is the binary search tree class that implements the node class

public class BST {

   private BSTNode root;//root node
   
   public BST() { this.root = new BSTNode(); }//default constructor
   public BST(String s) { this.root = new BSTNode(s); }//string constructor
   public BST(BSTNode n) { this.root = new BSTNode(n); }//root constructor
   public BST(BST b) { this.root = new BSTNode(b); }//copy constructor
   
   public BSTNode getRoot() { return this.root; }//get this root
   public void setRoot(BSTNode n) { this.root = n; }//set this root
   
   public String getRootData() { return this.root.getData(); }//get the root's data
   public void setRootData(String s) { this.root.setData(s); }//set the root's data
   
   public void empty() { this.root.emptyNode(); }//empty this BST
   public boolean isEmpty() { return this.root.isEmpty(); }//is this tree empty?
   
   public void insert(String title) {//insert node
      if(this.isEmpty()) this.root.setData(title);
      else this.insert(title, this.root);
   }//end method insert
   protected void insert(String title, BSTNode n) {//recursive insert
      if(n.isEmpty()) n.setData(title);//base case for root node
      else {
         if(n.getLeft()==null) {//first branch left
            n.setLeft(new BSTNode());
            insert(title,n.getLeft());
         } else if (n.getRight()==null) {//first branch right
            n.setRight(new BSTNode());
            insert(title,n.getRight());
         } else {
            if(n.getLeft().hasChildren() && !n.getLeft().hasChildren()) 
               insert(title, n.getRight());//go right if left is full
            else insert(title,n.getLeft());//otherwhise go left
         }
      } 
   }//end recursive insert
   
   public BSTNode find(String title) {//find node
      BSTNode node = new BSTNode();
      if(!this.isEmpty()) node = find(title, this.root);//else recursively search
      return node;//default false, value not found in tree
   }//end method find
   protected BSTNode find(String title, BSTNode n) {//recursive find
      BSTNode result = new BSTNode();//return node
      if(n!=null) {//keep looking for data if not null
         if(title.equals(n.getData())) return n;
         if((result=find(title,n.getLeft()))!=null) return result;
         return find(title,n.getRight());
      }
      return null;//the final null
   }//end recursive find
   
   public boolean remove(String title) {//remove node
      if(this.root.getData().equals(title) && this.root.isALeaf()) {
         this.root.emptyNode();
         return true;
      }
      if(this.isEmpty()) return false;
      else { 
         BSTNode b = remove(title,this.root);
         if(b!=null)return true;
         else return false;
      }
   }//end method remove
   protected BSTNode remove(String title, BSTNode n) {//recursive remove node
      if(n==null) {
         return null;
      }
      if(title.compareTo(n.getData())==0) {
         if(n.getLeft()==null) return n.getRight();
         else if(n.getRight()==null) return n.getLeft();
         else {
            n.setData(getRightmost(n.getLeft()));
            n.setLeft(remove(n.getData(),n.getLeft()));
         }
      } else {
         if(title.compareTo(n.getData())<0) {
            n.setLeft(remove(title,n.getLeft()));
         } else {
            n.setRight(remove(title,n.getRight()));
         }
      }
      return n;
   }
   
   protected String getRightmost(BSTNode n) {
      assert(n!=null);
      BSTNode r = n.getRight();
      if(r==null) return n.getData();
      else return getRightmost(n.getRight());
   }
   
}//end class BST