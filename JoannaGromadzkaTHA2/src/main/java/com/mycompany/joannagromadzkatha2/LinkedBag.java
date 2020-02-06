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
public class LinkedBag<T> implements BagInterface<T> {
    //data field
    private Node firstNode; //reference to first node
    private int numberOfEntries;
    
    //default constructor
    public LinkedBag(){
        firstNode=null;
        numberOfEntries=0;
    } 
    
    //inner private class Node
    private class Node{
        //data field
        private T data; //entry in bag
        private Node next; // link to next node
        
        //consrtuctor for node class
        private Node(T dataPortion){
            this(dataPortion,null);
        }
        //another constructor
        private Node(T dataPortion, Node nextNode){
            data=dataPortion;
            next=nextNode;
        }// end constructor
        
        private T getData() {
            return data;  
        } // end getData
        private void setData(T newData) {  
            data = newData;  
        } // end setData
        private Node getNextNode()   {
            return next;  
        } // end getNextNode
        private void setNextNode(Node nextNode){
            next = nextNode; 
        } // end setNextNode
    } // end Node
   
    
    /** Adds a new entry to this bag.
     * @param newEntry  The object to be added as a new entry.
     * @return  True. */
    public boolean add(T newEntry){// OutOfMemoryError possible
        //add to beginning of chain
        Node newNode=new Node(newEntry);
        newNode.next=firstNode;// Make new node reference rest of chain// (firstNode is null if chain is empty)     
        firstNode=newNode; // New node is at beginning of chain
        numberOfEntries++;
        return true;
    }
    
    /** retrieves all entries that are in this bag
    //@return A newly allocated array of all the entries in the bag. 
    //The method toArray returns an array of the entries  currently in a bag */
    public T[] toArray(){
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[]result =(T[])new Object[numberOfEntries];// Unchecked cast
        int index=0;
        Node currentNode=firstNode;
        while ((index<numberOfEntries)&&(currentNode !=null)){
            result[index]=currentNode.data;
            index++;
            currentNode=currentNode.next;
            
        }//endwhile
        return result;
    }
    /** Removes one unspecified entry from this bag, if possible.
     * @return  Either the removed entry, if the removal was successful, or null 
     */
    public T remove(){
        T result = null;
        
        if(firstNode != null){
            result = firstNode.data;
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
          
        } 
        return result;
    } 
     
    //Uses private helper method getReferenceTo
    /** Removes one specified entry from this bag, if possible.
     * @return  Either true or false*/
    public boolean remove(T anEntry){
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN!= null){
            nodeN.data= firstNode.data; //Replace located entry with entry in 1st
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
            System.out.println("Remove an entry "+ anEntry+" from the bag:");
            result = true;
        } // end if
        
        return result;
    } // end remove
    
    /**
    The getCurrentSize method should get the current number of entries in the bag.
    @return amount of entries in bag
    */
    public int getCurrentSize(){
      int result=numberOfEntries;
        System.out.println("The bag contains"+ result+"from get current size method");
        return result;
    }
     /** Sees whether this bag is empty.       
        @return  True if this bag is empty, or false if not. */  
    public boolean isEmpty()   {  
        return numberOfEntries == 0;} // end isEmpty 
    
     /** Removes all entries from this bag. */
    public void clear(){
        System.out.println("Clearing the bag");
        while (!isEmpty())
            remove();
        
    } // end clear
    
    
     /** Counts the number of times a given entry appears in this bag.
     * @param anEntry  The entry to be counted.
     * @return  The number of times anEntry appears in the bag.*/
    public int getFrequencyOf(T anEntry){
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;
        
        while((loopCounter < numberOfEntries) && (currentNode != null)){
            if (anEntry.equals(currentNode.data)){
                frequency++;
            } 
            loopCounter++;
            currentNode = currentNode.next;
        } // end while
        System.out.println("In this bag, the count of "+ anEntry +" is "+ frequency);
        return frequency;
    } // end get
    
    /** Tests whether this bag contains a given entry.
     * @param anEntry  The entry to locate.
     * @return  True if the bag contains anEntry, or false otherwise */
    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)){
            if(anEntry.equals(currentNode.data)){
                System.out.println("true");
                found = true;
        } else 
        currentNode = currentNode.next;  
    } // end while
        return found;   
    } // end contains
    

      //Private helper method getReferenceTo
// Locates a given entry within this bag.
// Returns a reference to the node containing the entry, if located,
// or null otherwise.
    private Node getReferenceTo(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.data)){
                found = true;
            } else 
                currentNode = currentNode.next;
    } // end while
    return currentNode;
    } // end getReferenceTo
     
   /**
     * The replace method should replace an unspecified entry in the bag with a given object.
     * Replace unspecified entry in the bag with the entry Z:

     * @param  element to be replaced with
     * 
     */
    public void replace(T anEntry){
     
        firstNode.data=anEntry;
      
        System.out.println("Replace unspecified entry in the bag with the entry "+anEntry);
      System.out.println("The bag contains "+numberOfEntries+ " string(s), as follows:");
      Node currentNode = firstNode;
      while(currentNode != null){
          System.out.print(currentNode.data);
          currentNode=currentNode.next;
      }
        System.out.println();
    
    }
    
    /**
     * The removeEvery method should remove every occurrence of a given entry from the bag.
     * @param element to be removed
     * Remove every occurrence of the entry A from the bag
     */
    public void removeEvery(T anEntry){
    
         Node currentNode = firstNode;
         while(currentNode!= null){
            //pointing with current to A:
            if(anEntry.equals(currentNode.data)){
                
                 //GOAL:remove 1st node here
                 remove(anEntry); 
                
            } else 
                currentNode = currentNode.next;
        }
    }

    
 

}
