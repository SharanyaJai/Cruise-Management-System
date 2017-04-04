/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narnia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import static narnia.Ship.conflict;

/**
 * Manages Passengers of the cruise
 * @author sharanya
 */
public class Passengers {

    int passNo;
    String passName;
    String passAdd;
    Date passDob;
    String passengerdateofbirth;
    String passNationality;
    double moneypaid;
    double moneySpent;
    int rating;
    int count = 1;
    int c = 1;
    static double totRevenue = 0;
    static double average = 0;
    static ArrayList<Passengers> passengerobj = new ArrayList<Passengers>(300); //Array list of Passengers to keep track of Passengers
    Boolean[] blockedPass = new Boolean[100]; //Array to know if a passenger has already been added to the cruie or not
  /**
   * Defines Passenger objects and sets their attributes
   */
    public void setData() {
        
        for (int i=0;i<100;i++)
        {
        blockedPass[i]=Boolean.FALSE;
        }
        
        try {

            c = 1;
            BufferedReader in = new BufferedReader(new FileReader("Pass.txt")); //reads input from Passenger text file
            String s;
            s = in.readLine();
            Random r1=new Random();
           int x1 = r1.nextInt(100 - 1) + 1;
            while (blockedPass[x1] == Boolean.TRUE) { //Checks if a passenger has already been read from the text file, if read already, chooses another passenger
                //   System.out.println("Pass No" + (x1 + 1) + " is blocked");
                x1 = r1.nextInt(100 - 1) + 1;
                
            }
            while (c <= x1) {
                s = in.readLine();
                c++;
            }

            count++;
            StringTokenizer str = new StringTokenizer(s, "|"); //Tokenizes read string and allocates the value to different attributes
            passNo = Integer.parseInt(str.nextElement().toString());
            passName = str.nextElement().toString();
            passAdd = str.nextElement().toString();
            passNationality = str.nextElement().toString();

            SimpleDateFormat sdfmt1 = new SimpleDateFormat("dd/MM/yyyy");
            passengerdateofbirth = str.nextElement().toString();
            passDob = sdfmt1.parse(passengerdateofbirth);

            moneypaid = Double.parseDouble(str.nextElement().toString());

            moneySpent = Double.parseDouble(str.nextElement().toString());
            Random r = new Random();

            rating = r.nextInt(5 - 1) + 1;
            Passengers temp = new Passengers(); //Temporary passenger object is created and is added to an arraylist of passengers
            temp.passNo = this.passNo;
            temp.passName = this.passName;
            temp.passAdd = this.passAdd;
            temp.passNationality = this.passNationality;
            temp.passDob = this.passDob;
            temp.moneySpent = this.moneySpent;
            temp.moneypaid = this.moneypaid;
            temp.passengerdateofbirth = this.passengerdateofbirth;
            temp.rating = this.rating;

            passengerobj.add(temp);
            blockedPass[x1]=Boolean.TRUE;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints Passenger data according to different criteria- age and money spent on board,Has been made static to facilitate direct invocation from Report Generation Class
     */
    static void passPrintData() {
        int k = 0;

        Passengers temp = new Passengers();

        int j;

        System.out.println("\n\n"); 
        for (int i = 0; i < passengerobj.size(); i++) { //Sorting in ascending order of money spent on board

            for (j = passengerobj.size() - 1; j > i; j--) {
                if (passengerobj.get(i).moneySpent > passengerobj.get(j).moneySpent) {

                    Passengers tmp = new Passengers();
                    tmp = passengerobj.get(i);
                    passengerobj.set(i, passengerobj.get(j));
                    passengerobj.set(j, tmp);

                }

            }

        }

        k = 0;
        System.out.println("Sorting in ascending order of money spent on board"); //Printing passengers to console based on Money spent on board
        System.out.printf("%-30s %-20s %-20s\n", "Passenger Name", "Money Spent on Board", "Nationality");
        while (passengerobj.size() > k) {

            System.out.printf("%-30s %-20.2f %-20s\n", passengerobj.get(k).passName, passengerobj.get(k).moneySpent / 1000, passengerobj.get(k).passNationality);
            totRevenue = totRevenue + passengerobj.get(k).moneySpent / 1000 + passengerobj.get(k).moneypaid / 1000;
            k++;
        }
        System.out.println("\n\nTotal Revenue generated in this cruise:"); //prints  total revenue generated
        System.out.printf("%-5.2f thousand", totRevenue/10000);

        //sorting by age
        for (int i = 0; i < passengerobj.size(); i++) { //Sorting in ascending order of passengers' age

            for (j = passengerobj.size() - 1; j > i; j--) {
                if (passengerobj.get(i).passDob.after(passengerobj.get(j).passDob)) {

                    Passengers tmp = new Passengers();
                    tmp = passengerobj.get(i);
                    passengerobj.set(i, passengerobj.get(j));
                    passengerobj.set(j, tmp);

                }

            }

        }
        k = 0;
        System.out.println("\nSorting passengers according to age\n\n"); //Printing passengers on console according to age
        System.out.printf("%-30s %-20s %-20s %-20s\n", "Passenger Name", "Money Spent on Ship", "Nationality", "DOB");
        while (passengerobj.size() > k) {

            System.out.printf("\n%-30s %-20.2f %-20s %-20s", passengerobj.get(k).passName, passengerobj.get(k).moneySpent / 1000, passengerobj.get(k).passNationality, passengerobj.get(k).passengerdateofbirth);

            totRevenue = totRevenue + passengerobj.get(k).moneySpent / 1000 + passengerobj.get(k).moneypaid / 1000;
            k++;
        }
   totRevenue=totRevenue/1000;
        // System.out.println("\n\nSorting by nationality follows");
        for (int i = 0; i < passengerobj.size(); i++) {

            for (j = passengerobj.size() - 1; j > i; j--) {
                if (passengerobj.get(i).passNationality.compareTo(passengerobj.get(j).passNationality) > 0) {

                    Passengers tmp = new Passengers();
                    tmp = passengerobj.get(i);
                    passengerobj.set(i, passengerobj.get(j));
                    passengerobj.set(j, tmp);

                }

            }

        }
        k = 0;
        

        
    }
/**
 * Calculates average rating of cruise given by passengers
 */
    public static void averagerating() {
        int k = 0;
        while (passengerobj.size() > k) {
            average = average + passengerobj.get(k).rating;
            k++;
        }
        average = average / passengerobj.size();

        System.out.print("\n\nAverage customer rating for this cruise given by " + passengerobj.size() + " is: "); //prints the rating to console
        System.out.printf("%-2.2f on 5\n",average);

        System.out.println("Grouping by Nationality\n");  // Groups Passengers according to country and prints on console
        k = 0;
        try{
        while (passengerobj.size() > k) {
            System.out.println("\nCountry:" + passengerobj.get(k).passNationality);
            System.out.println("Passenger Name      Money Spent");
            while (passengerobj.get(k).passNationality.compareTo(passengerobj.get(k + 1).passNationality) == 0) {
                System.out.printf("%-20s %-20.2f\n", passengerobj.get(k).passName, passengerobj.get(k).moneySpent / 1000);
                k++;
            }
            if (k + 1 < passengerobj.size()) {
                while (passengerobj.get(k).passNationality.compareTo(passengerobj.get(k + 1).passNationality) != 0) {
                    if (k < passengerobj.size()) {
                        System.out.printf("%-20s %-20.2f\n", passengerobj.get(k).passName, passengerobj.get(k).moneySpent / 1000);
                    }
                    if (k + 1 < passengerobj.size()) {
                        System.out.println("\n\nCountry:" + passengerobj.get(k + 1).passNationality);
                         System.out.println("Passenger Name      Money Spent");
                        System.out.printf("%-20s %-20.2f\n", passengerobj.get(k + 1).passName, passengerobj.get(k + 1).moneySpent / 1000);
                    }
                    k = k + 2;
                }

            }
        }
        }
        catch(Exception e)
        {
            
        }

    }
    /**
     * Compares revenue and expenses and prints company's profitability
     */

    public static void profitability() {
        System.out.printf("\n\nProfitability Report:\nCompany's total Revenue is %-2.2f \nCompany's Expense (Salary +fixed costs 10000) is %-2.2f",totRevenue ,Sailor.totalsalary + 10000);

        if ((Sailor.totalsalary + 10000) > totRevenue) {
            System.out.println("\n\nYes! Narnia Systems has profited");
        } else {
            System.out.println("\n\nNo! Narnia Systems has run into a loss");

        }

    }

}
