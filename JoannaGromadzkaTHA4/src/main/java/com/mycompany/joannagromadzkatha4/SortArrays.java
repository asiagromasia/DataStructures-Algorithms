/*
 * Write an algorithm to sort the rows of the 2D array by their first value.
 */
package com.mycompany.joannagromadzkatha4;
import java.util.*;
/**
 *AD325-5207
 * @author Joanna Gromadzka
 * Comparator and sorting
 */
public class SortArrays {
    public static void main(String[] args) {
        //O(n^2)
        //initial 2dm array declared
      Integer[][] array = new Integer[][]{{1, 2, 3, 4, 5},
                        {3, 4, 5, 1, 2},
                        {5, 2, 3, 4, 1},
                        {2, 3, 1, 4, 5},
                        {4, 2, 3, 1, 5}};
      //created comparator object 
      Comparator<Integer[]> arrayComparator = new Comparator<Integer[]>() {
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[0].compareTo(o2[0]);
           
        }
      };
       
    Arrays.sort(array, arrayComparator);
    for (Integer[] arr : array) {
        System.out.println(Arrays.toString(arr));
    }

    };
 
}
