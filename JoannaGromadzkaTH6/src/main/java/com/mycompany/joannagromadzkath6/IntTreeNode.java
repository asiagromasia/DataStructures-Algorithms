/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkath6;

/**
 *
 * @author szkola
 */
public class IntTreeNode {
    public int data;            // data stored at this node  
    public IntTreeNode left;    // reference to left subtree  
    public IntTreeNode right;   // reference to right subtree   
    
// Constructs a leaf node with the given data.   
    public IntTreeNode(int data) {     
        this(data, null, null); 
    }
     //Constructs a branch node with the given data and links. 
    public IntTreeNode(int data, IntTreeNode left,  
            IntTreeNode right) {     
        this.data = data;     
        this.left = left;    
        this.right = right;    }
    
    
    
}
