/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narnia;

import java.io.IOException;
import java.util.Scanner;

/**
 * Manages Report generation
 * @author sharanya
 */
public class Reports {

    /**
     * Generates Reports based on the input entered
     * @throws IOException 
     */
    static public void reportGeneration() throws IOException {
      System.out.println("\n\n(Currency is AUD)\nEnter the following option to generate Reports on the following:\n1. Sailor Reports and Total Salary\n2. Port Reports and Docking fees\n3. Print Cruise Reports to file \n4. Print Passenger Reports- Sort by age and Money Spent on board\n5. Display Profitability \n6. Print Customer Satisfaction and Group Passengers by Country \n0.(or any other key)To Quit");
    
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        while(choice!=0)
        {switch (choice) {
            case 1:
                Sailor.sailorPrintData(); //Prints Sailor data for Option 1
               
                break;
            case 2:
                Port.displayPorts(); //Prints Ports data on console for Option 2
               
                break;
            case 3:
                Cruise.cruisePrint(); //Prints Cruise data to CruiseReports File for Option 3
          
                break;
            case 4:

               Passengers.passPrintData(); //Generates report on Passengers on console - sorts according to Money spent on board and age for option 4
               break;
            case 5:
              
               Passengers.profitability(); // Prints if Narnia has profited or not on cosole for option 5
              break;
            case 6:  Passengers.averagerating();// Prints Average Customer rating and groups passengers according to country for option 6
                break;
            case 0: System.out.println("Thankyou! Exiting");  //Exits for option 0
                    System.exit(0);
            default:
               System.exit(0);
               
            
        }
        System.out.println("\n\n Please enter the following options to generate Reports on the following:\n1. Sailor Reports and Total Salary\n2. Port Reports and Docking fees\n3. Print Cruise Reports to file \n4. Print Passenger Reports- Sort by age and Money Spent on board\n5. Display Profitability \n6. Print Customer Satisfaction and Sort Passengers by Country and QUIT\n0. To Quit");
        choice=sc.nextInt();
        }
        System.out.println("Thank you! System exiting");
    }

}
