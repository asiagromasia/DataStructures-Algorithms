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
public class TowersOfHanoiTest {
    public static void main(String[] args) {
        
        //1st object
        TowersOfHanoi towers = new TowersOfHanoi();
        towers.totalDisks=3;
        
        // 2nd object
        TowersOfHanoi towers2 = new TowersOfHanoi();
        towers2.totalDisks=3;
        
        System.out.println("Compare the two solveTowers methods for 3 disks:");
        //1st method test
        towers.solveTowers(3,1,2,3);
        
        System.out.println("Tower of size "+ towers.totalDisks + " solved with "+towers.counter+" recursive calls using the first solveTowers method");
        System.out.println();
        
        //2nd method test
        towers2.solveTowers2(3,1,2,3);
        System.out.println("Tower of size "+ towers2.totalDisks + " solved with "+towers2.counter+" recursive calls using the second solveTowers2 method");
        
    }
    
}
