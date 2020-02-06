/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkatha2;

/**
 *
 * @author szkola
 */
public class LinkedBagTest {
    public static void main(String[] args) {
        System.out.println("Creating an empty bag");
        BagInterface<String> aBag = new LinkedBag<>();
      
        //craete the array
        String[]contentsOfBag={"A","D","B","A","C","A","D"};
        testAdd(aBag,contentsOfBag);
        aBag.getCurrentSize();
        testIsEmpty(aBag, false);
        System.out.println();
        testGetFrequencyOf(aBag,contentsOfBag);
        testContains(aBag,contentsOfBag);
      
       testRemove(aBag);
       aBag.getCurrentSize();
       testAdd(aBag,contentsOfBag);
     
       aBag.remove("B");
       displayBag(aBag);
       aBag.clear();
       testIsEmpty(aBag, true);
       displayBag(aBag);
       testAdd(aBag,contentsOfBag);
     
       aBag.replace("Z");
       aBag.removeEvery("A");
       displayBag(aBag);
       aBag.getCurrentSize();
       
  
        
    }
    private static void testAdd(BagInterface<String> aBag,String[]content){
        System.out.print("adding to the bag: ");
        for (int index=0; index<content.length;index++){
            if (aBag.add(content[index]))
                System.out.print(content[index] + " ");
            else System.out.println("unable to add" + content[index]+" to the bag");
            
        }
        System.out.println();
        displayBag(aBag);
        
    }
    private static void displayBag(BagInterface<String> aBag){
        Object[] bagArray=aBag.toArray();
        System.out.println("The bag contains " +bagArray.length +" string(s), as follows:");
        for (int index=0;index<bagArray.length;index++){
            
            System.out.print(bagArray[index]+ " ");
        }
        System.out.println();
      
    }
     
// Precondition: If bag is empty, the parameter empty should be true;
// otherwise, it should be false.
    private static void testIsEmpty(BagInterface<String> bag, boolean empty) {
       System.out.print("\nTesting isEmpty with ");
       if (empty)     
           System.out.println("an empty bag:");
       else      
           System.out.println("a bag that is not empty:");   
       System.out.print("isEmpty finds the bag ");
       if (empty && bag.isEmpty())
           System.out.println("empty: OK.");
       else if (empty)System.out.println("not empty, but it is: ERROR.");
       else if (!empty && bag.isEmpty())
           System.out.println("empty, but it is not empty: ERROR.");
       else System.out.println("not empty: OK.");    
    } // end testIsEmpty

    private static void testGetFrequencyOf(BagInterface<String> aBag,String[]content) {
        
         System.out.println("Testing the method getFrequencyOf:");
            for (int index=0;index<content.length;index++){
                if((aBag.getFrequencyOf(content[index]))!=0){
                  //  aBag.getFrequencyOf(content[index])
                    
                }else  System.out.println("unable to find" + content[index]+" in the bag");
                                
            }
            System.out.println();
           
    }

    private static void testContains(BagInterface<String> aBag, String[] content) {
        System.out.println("Testing the method contains:");
        System.out.println();
        for (int index=0;index<content.length;index++){
             System.out.print("Does this bag contain "+content[index]+"?"); 
                if(aBag.contains(content[index])){
                    System.out.println();
                   
                } else System.out.println("unable to find" + content[index]+" in the bag");
                                
            }
    }

    private static void testRemove(BagInterface<String> aBag) {
        
        Object[] bagArray=aBag.toArray();
        for (int index=0;index<bagArray.length;index++){
        System.out.println("Removing a string from the bag:"+ bagArray[index]);
        
          if(aBag.remove()!=null){
             
            System.out.println("returns "+bagArray[index]);
        } else System.out.println("no more to remove");
           
        } 
        
    }
   
    
}


