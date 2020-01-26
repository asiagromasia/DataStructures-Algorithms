/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkatha1;

/**
 * @author Joanna Gromadzka
 * AD 325 5207
 * Assignment 1
 * Creating class, interface, test, methods and implementing it
 * 
 */
public interface PileInterface<T> {

   /*adds a new book to the top of the pile
    *@param newBook - title string of new book to be added to the pile
    *@return confirmation true if book added
    */
    Boolean add(T newBook);
    
    /*
    *@param string with book title on the top
    *@return  book title being removed or null if its empty
    */
    T remove();
    
    /*
    *@param none
    *@return the title of the book from the top of the pile or null if is empty
    */
    T getTopBook();
    
    /*
    *@param
    *@return true if pile is empty
    */
    boolean isEmpty();
    
    /*
    *should remove all books from this pile
    *@param none
    *@return none
    */
    void clear();
    
    /** Retrieves all entries that are in pile.
     * @return  A newly allocated array of all the entries in the bag.    
     * Note: If the pile is empty, the returned array is empty. */
    T[] toArray();
    
    
}
