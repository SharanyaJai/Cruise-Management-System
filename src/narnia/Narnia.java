/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narnia;

/**
 *
 * Main class, calls Cruise class from here, simulates the cruise
 * @author sharanya
 */
public class Narnia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
         {
            Cruise cruise1 = new Cruise();

            
            cruise1.createCruise(); // creates cruise
            cruise1.setPorts();// calls setport methods
            cruise1.displayData();//displays data

        } 

    }
}
