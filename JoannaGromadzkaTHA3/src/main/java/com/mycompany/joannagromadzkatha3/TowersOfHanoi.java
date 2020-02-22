/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.joannagromadzkatha3;

/*
 * AD325-5207 Data Structures and Algorythms/ Towers of Hanoi solved with 2 recursion methods
 * Assgm 3
 * @author Joanna Gromadzka
 */
public class TowersOfHanoi {
    //data fields
    int totalDisks;
    int counter;

    //constructor
    public TowersOfHanoi() {
        totalDisks =0;
        counter = 0;
    }

    //methods
    public void solveTowers(int numDisks, int start, int temp, int end) {
        if (numDisks ==1) {
            //Move disk from startPole to endPole
            System.out.println("Move disk "+ numDisks+ " from "+ start+" to "+ end);
            counter = counter+1;
            
        }
        else {
            counter++;
            //Move all but the bottom disk from startPole to tempPole
            solveTowers(numDisks-1, start, end, temp);
            //Move disk from startPole to endPole
            System.out.println("Move disk "+ numDisks+ " from "+start+" to "+end);
            //Move all disks from tempPole to endPole
            solveTowers(numDisks-1, temp, start, end);
        }
    }
    
    
    public void solveTowers2(int numDisks, int start, int temp, int end) {
        if (numDisks>0) {
           //Move all but the bottom disk from startPole to tempPole
            solveTowers2(numDisks-1, start, end, temp);
            counter++;
            //Move last disk from startPole to endPole
            System.out.println("Move disk "+ numDisks+ " from "+start+" to "+end);
            //Move all disks from tempPole to endPole
            solveTowers2(numDisks-1, temp,start,end);
            counter++;
        } 
    }
}
