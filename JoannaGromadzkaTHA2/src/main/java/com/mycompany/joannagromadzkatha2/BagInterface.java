/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkatha2;

/**
 *@author Joanna Gromadzka
 * AD 325 5207
 * Assignment 2
 * LinkedBag (A bag implementation that links data)
 */
public interface BagInterface<T> {
    
    /** Adds a new entry to this bag.
     * @param newEntry  The object to be added as a new entry.
     * @return  True. */
    boolean add(T newEntry);
    
    /** retrieves all entries that are in this bag
    //@return A newly allocated array of all the entries in the bag.*/
    T[]toArray();
    
    /** Removes one unspecified entry from this bag, if possible.
     * @return  Either the removed entry, if the removal was successful, or null 
     */
     T remove();
     
     /**
      * The remove(T anEntry) method should remove one occurrence of a given entry from the bag, if possible.
      //Uses private helper method getReferenceTo
    /** Removes one specified entry from this bag, if possible.
     * @return  Either true or false*/
    boolean remove(T anEntry);
    
    /**
    The getCurrentSize method should get the current number of entries in the bag.*/
    int getCurrentSize();
    
    /** Sees whether this bag is empty.       
        @return  True if this bag is empty, or false if not. */  
    boolean isEmpty();  
     
    
     /** Removes all entries from this bag. */
    void clear();
    
    /** Counts the number of times a given entry appears in this bag.
     * @param anEntry  The entry to be counted.
     * @return  The number of times anEntry appears in the bag.*/
    int getFrequencyOf(T anEntry);
    
    /** Tests whether this bag contains a given entry.
     * @param anEntry  The entry to locate.
     * @return  True if the bag contains anEntry, or false otherwise */
    boolean contains(T anEntry);
    
    /**
     * The replace method should replace an unspecified entry in the bag with a given object.
     */
    void replace(T anEntry);
    
    /**
     * The removeEvery method should remove every occurrence of a given entry from the bag.
     */
    void removeEvery(T anEntry);
}
