/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkatha7;

import java.util.Arrays;

/**
 * AD325-5207
 * @author Joanna Gromadzka
 * creating interface, methods and testing them for MinHeap 
 */
public class MinHeap<T extends Comparable<?super T>>implements MinHeapInterface<T> {
    
    private T[] heap;// Array of heap entries; ignore heap[0]
    private int lastIndex; // Index of last entry and number of entries
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    public MinHeap()   {
        this(DEFAULT_CAPACITY); // Call next constructor  
    } // end default constructor 
    
    public MinHeap(int initialCapacity){
    // Is initialCapacity too small?
        if (initialCapacity < DEFAULT_CAPACITY)     
            initialCapacity = DEFAULT_CAPACITY;
        else// Is initialCapacity too big?       
            checkCapacity(initialCapacity);
        // The cast is safe because the new array contains null entries 
        @SuppressWarnings("unchecked")   
                T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
        // First array element is not used    
        heap = tempHeap;     
        lastIndex = 0;//empty heap   begin the heap at index 1  
        integrityOK = true; 
    } 
    
    public MinHeap(T[] entries){
        this(entries.length); // Call other constructor  
        lastIndex = entries.length;
         // Assertion: integrityOK = true
        // Copy given array to data field
        for (int index = 0; index < entries.length; index++)   
            heap[index + 1] = entries[index];//begin the heap at index 1
        // Create heap
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
            reheap(rootIndex);
    } 
    
    public T getMin(){
        checkIntegrity();    
        T root = null;
        if (!isEmpty())    
            root = heap[1];
        return root; 
    } 
    
    public boolean isEmpty() {
        return lastIndex < 1;
    } 
    
    public int getSize() {
        return lastIndex;  
    } 
    
    public void add(T newEntry) {
        checkIntegrity();  
        // Ensure initialization of data fields
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
          while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) < 0)   { 
            heap[newIndex] = heap[parentIndex];   
            newIndex = parentIndex;   
            parentIndex = newIndex / 2; 
         } 
        heap[newIndex] = newEntry;  
        lastIndex++; 
        ensureCapacity(); 
    } 
    
    
    public T removeMin(){
       checkIntegrity();     
       // Ensure initialization of data fields 
       T root = null;
       if (!isEmpty()) {   
           root = heap[1];// Return value  
           heap[1] = heap[lastIndex]; // Form a semiheap  
           lastIndex--;  // Decrease size  
           reheap(1);   // Transform to a heap  
       } 
       return root;
    }
   
    private void reheap(int rootIndex){
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        
        while (!done && (leftChildIndex <= lastIndex)){// heap[rootIndex] has a child 
            int largerChildIndex = leftChildIndex; //larger? 
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && 
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) < 0){    
                    largerChildIndex = rightChildIndex;   
            } 
            if (orphan.compareTo(heap[largerChildIndex]) > 0){  
                heap[rootIndex] = heap[largerChildIndex];     
                rootIndex = largerChildIndex;      
                leftChildIndex = 2 * rootIndex;   
            }else    
                done = true;
        } 
            heap[rootIndex] = orphan;
    } 
    
    
    public void clear(){
        checkIntegrity();
        while (lastIndex > -1) { 
        heap[lastIndex] = null;     
        lastIndex--;   
        }   
        lastIndex = 0; 
    } 
    
   ////////  PRIVATE METHODS    ////////
    private void ensureCapacity(){   
        int numberOfEntries = lastIndex;
        int capacity = heap.length - 1; 
        
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity); // Is capacity too big?      
            heap = Arrays.copyOf(heap, newCapacity + 1);   
        } 
            } 
    // Throws an exception if this object is corrupt.
    private void checkIntegrity(){
        if (!integrityOK)throw new SecurityException ("MaxHeap object is corrupt.");
    } 
    
    private void checkCapacity(int capacity){
        if (capacity < DEFAULT_CAPACITY)capacity = DEFAULT_CAPACITY;
        else if (capacity > MAX_CAPACITY)throw new IllegalStateException("Attempt to create a heap " +"whose capacity is larger than " +MAX_CAPACITY);
    } 
    
    ///////***** HEAP SORT****///////
    public static <T extends Comparable<?super T>> void heapSort(T[] array, int n){
        // Create first heap
        for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--)
            reheap(array, rootIndex, n - 1); 
            swap(array, 0, n - 1);
        
        for (int lastIndex = n - 2; lastIndex > 0; lastIndex--){
            reheap(array, 0, lastIndex);   
            swap(array, 0, lastIndex); 
        } 
    } 
    
    private static <T extends Comparable<? super T>>void reheap(T[] heap, int rootIndex, int lastIndex){
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex + 1;
       
        while (!done && (leftChildIndex <= lastIndex)){
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            
            if ( (rightChildIndex <= lastIndex) &&     
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {  
                largerChildIndex = rightChildIndex;
               } // end if
            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];     
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex + 1;   
                }else      
                done = true;  
        } // end while
        heap[rootIndex] = orphan;
    } // end reheap
    
    private static <T extends Comparable<? super T>> void swap(T[] array, int first ,int last){ 
        T temp= array[last];     
        array[last]=array[0];     
        array[0]=temp;  
    }
    
}
