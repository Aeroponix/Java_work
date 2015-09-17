/*
 * OutputNode.java
 *
 * Written By: Adam Lindsey
 * CIS315 Winter 2015 -- Assignment #2
 *
 */
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OutputNode {
    public static void main(String[] args) throws IOException {
    
      int i=0,//number of graphs being passed to program
            j,//loop variable
            k,//loop variable
      nodes=0,//number of nodes on a single graph
      edges=0,//number of edges for a single graph
            r,//loop variable
      nodeA=0,//node a for edge i (pointer node)
      nodeB=0,//node b for edge i (node being pointed at)
     booboo=0;//error flag
      
      boolean onShortest = true;
      int[][] matrix,temp;
      System.out.println("Please enter the filename of file to test.");//i.e. input.txt or test.txt
      Scanner s = new Scanner(System.in);
      String filename = s.nextLine();
      s.close();
      File file = new File(filename);
      s = new Scanner(file);
      try {
         i = s.nextInt();
      }
      catch(InputMismatchException a) {
         System.out.println("You must enter a number of graphs!");
      }
      for(j=0;j<i;j++) {
         node iteration = new node();
         iteration.setGraph(j+1);
         try {
            nodes = s.nextInt();
         }
         catch(InputMismatchException a) {
            System.out.println("You must enter a number of nodes!");
         }
         catch(Exception a) {
            System.out.println("Missing Nodes!");
         }
         try { matrix = new int[nodes][nodes]; }
         catch(Error a) {
            try{ r = s.nextInt(); }
            catch(InputMismatchException e) { r = 0; }
            if(nodes==r+1) {
               System.out.println("\n Graph Number: " + iteration.getGraph());
               System.out.println("Shortest Path: " + r);
               System.out.println(" Longest Path: " + r);
               if(r!=0)System.out.println("  Total Paths: 1");
               else System.out.println("  Total Paths: 0");
               booboo++;
            }
         }
         if(booboo==0) matrix = new int[nodes][nodes];
         else return;
         for(k=0;k<nodes;k++) {
            for(r=0;r<nodes;r++) {
               matrix[j][r] = 0;
            }
         }
         try {
            edges = s.nextInt();
         }
         catch(InputMismatchException a) {
            System.out.println("You must enter a number of edges!");
         }
         catch(Exception a) {
            System.out.println("This graph contains no edges!");
         }
         for(r=0;r<edges;r++) {
            try {
               nodeA = s.nextInt();
               nodeB = s.nextInt();
            }
            catch(InputMismatchException a) {
               System.out.println("You must enter an edge pair!");
            }
            catch(Exception a) {
               System.out.println("This graph contains no edges!");
            }
            matrix[nodeA-1][nodeB-1] = 1;
         }
         temp = matrix;
         
         //TODO: find answers
         for(k=0;k<nodes;k++) {
            if(!onShortest&&temp[0][nodes-1]<k+1) {
               iteration.setLongest(k);
            }
            if(onShortest&&temp[0][nodes-1]!=0) {
               onShortest=false;
               iteration.setShortest(k+1);
            }
            iteration.setPaths(iteration.getPaths() + temp[0][nodes-1]);
            temp = matrixMult(temp,matrix,nodes);
         }
         if(j==i-1&&!onShortest&&iteration.getLongest()==0) iteration.setLongest(iteration.getShortest());
         System.out.println("\n Graph Number: " + iteration.getGraph());
         System.out.println("Shortest Path: " + iteration.getShortest());
         System.out.println(" Longest Path: " + iteration.getLongest());
         System.out.println("  Total Paths: " + iteration.getPaths());
         onShortest = true;
      }
      s.close();
      
      if(i==0) System.out.println("There are no graphs to analyze!");
      if(nodes==0) System.out.println("There are no nodes to analyze!");
      if(edges==0) System.out.println("There are no edges to analyze!");
    }
    
    //method for matrix multiplication
    public static int[][] matrixMult(int[][] a, int[][] b, int size) {
      int n = (size),x,y,z,sum = 0;
      int[][] result = new int[n][n];
      for(x=0;x<n;x++) {
         for(y=0;y<n;y++) {
            for(z=0;z<n;z++) {
               sum = sum + (a[x][z]*b[z][y]);
            }
            result[x][y] = sum;
            sum = 0;
         }
      }
      return result;
    }
    
    public static class node {
      private int graphNum; //graph number from input file
      private int shortest; //shortest path from node 1 to n
      private int longest;  //longest path from node 1 to n
      private int pathNum;  //the number of distinct paths from 1 to n
      
      public node() {
         this.graphNum = 0;
         this.shortest = 0;
         this.longest  = 0;
         this.pathNum  = 0;
      }
      public node(node n) {
         this.graphNum = n.getGraph();
         this.shortest = n.getShortest();
         this.longest  = n.getLongest();
         this.pathNum  = n.getPaths();
      }
      
      int getGraph() { return this.graphNum; }
      void setGraph(int n) { this.graphNum = n; }
      
      int getShortest() {return this.shortest;}
      void setShortest(int n) {this.shortest = n;}
      
      int getLongest() {return this.longest;}
      void setLongest(int n) {this.longest = n;}
      
      int getPaths() { return this.pathNum; }
      void setPaths(int n) { this.pathNum = n; }
    }
}