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
public class IntSearchTreeClient {
    public static void main(String[] args) {
        
        int[] list = {55,29,87,-3,42,60,91};
        int[] list1 = {60,55,100,45,57};   
        IntSearchTree numbers = new IntSearchTree();
        for(int i:list){
            numbers.add(i);
        }
        //System.out.println("numbers1="+ numbers1);
        numbers.print();
        IntSearchTree numbers1 = new IntSearchTree();
        for(int i:list1){
            numbers1.add(i);
        }
        numbers1.print();
        
       System.out.println();
        System.out.println(" binary search tree structure");
        numbers.printSideways();
        System.out.println("sorted list:");
        numbers.print();
        numbers.countLeftNodes();
       
        System.out.println("The number of left nodes is "+numbers.countLeftNodes());
        System.out.println("This is a full binary tree: "+ numbers.isFull()); 
        
        System.out.println();
        System.out.println();
        System.out.println(" binary search tree structure");
        numbers1.printSideways();
        System.out.println("sorted list:");
        numbers1.print();
        numbers1.countLeftNodes();
        System.out.println("");
        System.out.println("The number of left nodes is "+numbers1.countLeftNodes());
        System.out.println("This is a full binary tree: "+ numbers1.isFull());  
    }
        
}
