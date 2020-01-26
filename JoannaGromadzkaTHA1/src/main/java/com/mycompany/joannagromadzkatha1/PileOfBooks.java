/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkatha1;

import java.util.Arrays;

/**
 * @author Joanna Gromadzka
 * AD 325 5207
 * Assignment 1
 * Creating class, interface, test, methods and implementing it
 * 
 */
public class PileOfBooks<T> implements PileInterface<T> {
    
    private T[]pile;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static int DEFAULT_CAPACITY = 4;
    private static final int MAX_CAPACITY = 10000;
    
    //create constructor
    public PileOfBooks(){
        this(DEFAULT_CAPACITY);
    }
    public PileOfBooks(int desiredCapacity){
        if (desiredCapacity <= MAX_CAPACITY)
        {
        @SuppressWarnings("unchecked")
        //here is Unchecked cast        
        T[] tempBag= (T[])new Object[desiredCapacity]; //Cannot use a generic type when allocating an array, we allocate an array of objects of type Object
        pile=tempBag;
        numberOfEntries =0; //empty bag
        integrityOK=true;
        } else 
            throw new IllegalStateException("Attempt to create a bag whose" +                         
                    "capacity exceeds allowed maximum.");
    }
    
    //METHODS
    
    /** Retrieves all entries that are in this bag.
     * @return  A newly allocated array of all the entries in this pile.
     * Create the new array
     * 2.Create the loop to copy the references in the array bag to this new array
     * 3.Return this new array
     */
    public T[] toArray(){
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("uncheked")
        T[]result = (T[])new Object[numberOfEntries];
        for (int index=0;index<numberOfEntries;index++){
            result[index]=pile[index];
        }
        return result;
    }
    /*adds a new book to the top of the pile
    *@param newBook - title string of new book to be added to the pile
    *@return confirmation true if book added
    */
    public Boolean add(T newBook){
        checkIntegrity();
        boolean result = true;
        if (isArrayFull()){
            result=false;
            doubleCapacity();
            result = true;
            pile[numberOfEntries]= newBook;
            numberOfEntries++;
            
        }
        else { // Assertion: result is true here
            pile[numberOfEntries]= newBook;
            numberOfEntries++;
        }
        return result;
    }
   
    //helper privte method
    // Returns true if the array bag is full, or false if not.
    private boolean isArrayFull(){
        return numberOfEntries>=pile.length;
    }
    private void checkIntegrity(){
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
        
    }
     // Doubles the size of the array bag.
    // Precondition: checkIntegrity has been called.
    private void doubleCapacity()   {
                int newLength = 2 * pile.length;
                checkCapacity(newLength);   
              pile = Arrays.copyOf(pile, newLength);
            
            } // end doubleCapacity 
           
    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)   {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create too big pile. It is too dangerous. " + "capacity exeeds allowed " +"maximum of " + MAX_CAPACITY);  
    } // end checkCapacity
           
     /*
    *@return  book title being removed or null if its empty
    */
    public T remove(){
        T result=null;
        if(numberOfEntries!=0){
           //  System.out.println(" "+ numberOfEntries );
          // System.out.println(pile[pile.length-2]); 
           result=pile[pile.length-2];
           
            pile[pile.length-2]=null;
         //   System.out.println(pile[pile.length-2]); 
           // System.out.println(result);
            numberOfEntries--;
             
        }
           
        return result;
    }
    
    /*
    *@param none
    *@return the title of the book from the top of the pile or null if is empty
    */
    public T getTopBook(){
       T result=null;
        if(numberOfEntries>=1){
                                  //  result=pile[numberOfEntries];
                                 
        result= pile[pile.length-1];
        return result;
            //return pile[numberOfEntries];
                // result=pile[numberOfEntries];
        }
        
        return result;
    }
    
    /*
    *@param
    *@return true if pile is empty
    */
    public boolean isEmpty(){
        return numberOfEntries==0;
    }
    
    /*
    *should remove all books from this pile
    *@param none
    *@return none
    */
    public void clear(){
        while(!isEmpty()){
            remove();
        }
        
    }
    
}
