/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkatha7;

/**
 * AD325-5207
 * @author Joanna Gromadzka
 * creating interface, methods and testing them for MinHeap 
 */
public class MinHeapClient {
    public static void main(String[] args) {
        //creating 1st MinHeap empty object
        MinHeapInterface<String> myHeap1 = new MinHeap<>();
        
        myHeap1.add("Jared");
        myHeap1.add("Brittany");
        myHeap1.add("Brett");
        myHeap1.add("Doug");
        myHeap1.add("Megan");
        myHeap1.add("Jim");
        myHeap1.add("Whitney");
        myHeap1.add("Matt");
        myHeap1.add("Regis");
      
        testIsEmpty(myHeap1);
        System.out.println(" it contains "+myHeap1.getSize()+" entrie(s).");
        myHeap1.getMin();
        System.out.println("The smallest entry is " + myHeap1.getMin());
        System.out.println("Removing entries in ascending order:");
        while(!myHeap1.isEmpty()){
            System.out.println("Removing "+myHeap1.removeMin());
        }
        System.out.println();
     
        //creating array with elements
        String[] nameArray = {"Banana", "Watermelon", "Orange", "Apple", "Kiwi"};
        //creating 2nd MinHeap object with array parameter. 
        MinHeapInterface<String> myHeap2 = new MinHeap<>(nameArray);
        
        System.out.println("Testing constructor with array parameter:");
        testIsEmpty(myHeap2);
        System.out.println(" it contains "+myHeap2.getSize()+" entrie(s).");
        System.out.println("The smallest entry is " + myHeap2.getMin());
        System.out.println("Removing entries in ascending order:");
        while(!myHeap2.isEmpty()){
            System.out.println("Removing "+myHeap2.removeMin());
        }
    }
    //testing isEmpty method
    private static void testIsEmpty(MinHeapInterface<String>myHeap) {
       if(!myHeap.isEmpty()){
           System.out.print("The heap is not empty;");
       }
           else
           System.out.print("The heap is empty;");
    }
         
    
}
