/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkath6;

/**
 * AD325-5207
 * @author Joana Gromadzka
 */
public class IntSearchTree {
    private IntTreeNode overallRoot;
    
    //constructor
    public IntSearchTree(){
        overallRoot=null;
    }
    public void add(int value){
        overallRoot=add(overallRoot,value);
    }
    private IntTreeNode add(IntTreeNode root, int value){
        if(root==null){
            root=new IntTreeNode(value);
            
        }else if (value<root.data){root.left=add(root.left,value);
        
        }else if (value>root.data){root.right=add(root.right,value);
        } return root;
    }
    
    public boolean contains(int value){
        return contains(overallRoot,value);
    }
    private boolean contains(IntTreeNode root, int value){
        if(root==null){
            return false;
        } else if(root.data == value){
            return true;
        }else if (root.data > value) {  
            return contains(root.left, value);  
        } else {   // root.data < value     
        return contains(root.right, value);   
        }
    }
        
     public void print(){
         printInorder(overallRoot);
         System.out.println();
     }   
    
    public void printInorder(IntTreeNode root){
        if(root!=null){
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        
        }
    }
 
    
    public int countLeftNodes(){
      
        return countLeftNodes(overallRoot,0);
    }
    int counter;
    private int countLeftNodes(IntTreeNode root,int counter){
        if(root==null){
            return 0;
        } else 
            return counter+countLeftNodes(root.left,1)+countLeftNodes(root.right,0);
    };

   
    public boolean isFull(){
        return isFull(overallRoot);
    };
    private boolean isFull(IntTreeNode root){
         boolean result=false;
        if(root==null){
            result= true;
        }else if((root.left==null)&&(root.right==null)){
            result=true;
        }else if((root.left!=null)&&(root.right!=null)){
            isFull(root.left);
            isFull(root.right);
           result=true; 
        }
        return result;
    };
    
    public void printSideways(){
        printSideways(overallRoot, " ");
    }
    
    private void printSideways(IntTreeNode root, String indent){
        if(root!=null){
            printSideways(root.right, indent + "   ");
            System.out.println(indent + root.data);
            printSideways(root.left, indent+"   ");
            
            
        }
    }
}
