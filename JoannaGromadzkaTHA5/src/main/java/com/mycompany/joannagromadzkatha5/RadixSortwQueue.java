/*
 * Implement the radix sort algorithm by using a queue for each bucket.
Your program should demonstrate the use of queues in the execution of a radix sort.
In your main method, set up the array as below:
int[] list = {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241,6589, 6622, 1211};
 */
package com.mycompany.joannagromadzkatha5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *AD325-5207
 * @author Joanna Gromadzka
 * Radix sort using Queue for buckets
 */
public class RadixSortwQueue {
    public static void main(String[] args) {
        int[] list = {7840, 4568, 8765, 6543, 7865, 4532, 9987, 3241,6589, 6622, 1211};
        System.out.println("An Integer array before sorting");
        System.out.println(Arrays.toString(list));
        radixSort(list);
        System.out.println("Sorting an int array using radix sort algorithm");
        System.out.println(Arrays.toString(list));

    }
    public static void radixSort(int[] list) {
        // initialize array of 10 queues for digit value 0-9
        Queue<Integer>[] bucket = new LinkedList[10];
            //creates 10 buckets 
            for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
            }
        // move to/from buckets repeatedly until sorted
        int digit = 1;
            while (toBucket(list, digit, bucket)) {
            fromBucket(list, bucket);
            digit++;
            }
        }
    private static boolean toBucket(int[] list, int digit,Queue<Integer>[] bucket) {
            boolean nonZero = false;
            for (int element : list) {
            //assignes value of asked digit in array element  to n 
            int n = nDigit(element, digit);
            //place element from list into bucket where value matches the bucket number
            bucket[n].add(element);
            if (n != 0) {
            nonZero = true;
            }
        }
        return nonZero;
    }
    private static void fromBucket(int[]list,Queue<Integer>[] bucket) {
        int i = 0;
            for (int j = 0; j < bucket.length; j++) {
            while (!bucket[j].isEmpty()) {
            list[i] = bucket[j].remove();
            i++;
            }
        }
    }
    private static final int nDigit(int element, int n) {
        for (int i = 1; i <= n - 1; i++) {
        element = element / 10;
        }
        return element % 10;
     }
    
}
