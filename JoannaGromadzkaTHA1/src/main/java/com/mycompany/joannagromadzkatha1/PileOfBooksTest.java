/* Imagine a pile of books on your desk. Each book is so large and heavy that you can remove only the top one from the pile. You cannot remove a book from under another one. Likewise, you cannot add a book beneath another one. You can add another book to the pile only by placing it on the top of the pile.
If you represent books by their titles alone, design a class that you can use to track the books in the pile on your desk. Specify each operation by stating its purpose, by describing its parameters, and by writing a pseudocode version of its header. Then write a Java interface for the pile’s methods. Include javadoc-style comments in your code.
Define a class PileOfBooks that implements this interface. Use a resizable array in your implementation. Then write a program that adequately demonstrates your implementation.
In this program, you will need to have 1 class with the name as PileOfBooks, 1 interface with the name as PileInterface,  and 1 test class to test everything.
The followings are how books are added the 1st time in your test class:
myPile.add("And Then There Were None"); myPile.add("The Hobbit");myPile.add("The Lord of the Rings");myPile.add("The Da Vinci Code");myPile.add("The Catcher in the Rye");
Then you will need to add another pile of books later.
You will need to create the following methods: add, remove, getTopBook, isEmpty, clear.
The add method should add a new book to the top of this pile.
The remove method should remove and return this pile's top book.
The getTopBook method should retrieve this pile's top book.
The isEmpty method should detect whether this pile is empty.
The clear method should remove all books from this pile.
Make sure to make the Implementation Secure. You will need to create the following private methods: checkintegrity, checkCapacity, doubleCapacity, isArrayFull.
Please make the DEFAULT_CAPACITY = 4;
MAX_CAPACITY = 10000;
Throws an exception if the client requests a capacity that is too large. (IllegalStateException).
Throws an exception if receiving object is not initialized. (SecurityException)

 */
package com.mycompany.joannagromadzkatha1;


/**
 * @author Joanna Gromadzka
 * AD 325 5207
 * Assignment 1
 * Creating class, interface, test, methods and implementing it
 * 
 */
public class PileOfBooksTest {
    public static void main(String[] args) {
        //creates empty pile of books
        PileInterface<String> myPile = new PileOfBooks<>();
        testIsEmpty(myPile);
        System.out.println("Here I'm adding books to pile.");
        myPile.add("And Then There Were None");
        myPile.add("The Hobbit");
        myPile.add("The Lord of the Rings");
        myPile.add("The Da Vinci Code");
        myPile.add("The Catcher in the Rye");
        testIsEmpty(myPile);
        testGetTopBook(myPile);
        
        System.out.println();

        System.out.println("Testing peek and pop:");
        testGetTopBook(myPile);
        testRemove(myPile);
        System.out.println();
        testGetTopBook(myPile);
        testRemove(myPile);
        System.out.println();
        testGetTopBook(myPile);
        testRemove(myPile);
        System.out.println();
        testGetTopBook(myPile);
        testRemove(myPile);
        System.out.println();
        testGetTopBook(myPile);
        testRemove(myPile);
        System.out.println();
        System.out.println();
        testIsEmpty(myPile);
        System.out.println();
        String[] bookPile={" And Then There Were None","The Hobbit","The Lord of the Rings","The Da Vinci Code","The Catcher in the Rye"};
        testAdd(myPile,bookPile);
                    
        System.out.println("Here using clear");
        testClear(myPile);
        testIsEmpty(myPile);
       
        System.out.println();
        testGetTopBook(myPile);
        testRemove(myPile);    
    }
    private static void add(PileInterface<String> myPile,String newBook){    
        int numberOfEntries=0;
        while(!myPile.isEmpty()){
            myPile.add(newBook);
            numberOfEntries++;
        }
    }
    
    private static void testAdd(PileInterface<String> myPile, String[] content) {
            System.out.println("adding the following book to the pile:");
        String[] book=content;
        for(int index=0;index<content.length;index++){
            if(myPile.add(content[index]))
                System.out.print(content[index]+" ");
            else 
                System.out.print("\nUnable to add " + content[index] + "to the pile");
        }
            System.out.println();
            displayPile(myPile);
    }
            
    private static void displayPile(PileInterface<String>myPile){
            System.out.println("The Pile contains the following book(s):");
        Object[]pileArray=myPile.toArray();
        for(int index=0; index<pileArray.length;index++){
            System.out.print(pileArray[index]+ ", ");
        }
            System.out.println();
    }

    private static void testIsEmpty(PileInterface<String> myPile) {
            System.out.println("testing if is empty:");
        if(myPile.isEmpty()){
            System.out.println("true");
        } else 
            System.out.println("false");   
    }
    private static boolean isEmpty(){
        int numberOfEntries=0;
        if(numberOfEntries==0){
            System.out.println("it is true");
            return true;
        } else
            return false;
    }

    private static void testGetTopBook(PileInterface<String> myPile) {
        Object[]pileArray=myPile.toArray();
            if(!myPile.isEmpty()){
                myPile.getTopBook();
                System.out.println(pileArray[pileArray.length-1]+ " is at the top of the pile" );
            } else
                System.out.println("null");        
    }
    
    private static void testRemove(PileInterface<String> myPile) {
        Object[]pileArray=myPile.toArray();
            if(!myPile.isEmpty()){
                myPile.remove();
                System.out.println(pileArray[pileArray.length-1]+ " is removed from the pile");
            } else 
                System.out.println("null");
    }
        
    private static void testClear(PileInterface<String> myPile) {
       if(!myPile.isEmpty()){
           myPile.clear();
       }
    }    
}
