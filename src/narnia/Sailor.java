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
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

import static narnia.Ship.conflict;

/**
 * Manages Sailors and other derived classes of Sailors
 * @author sharanya
 */
public class Sailor {

    int sailorNo;
    String sailorName;
    Date sailorDob;
    String sailorNationality;
    double sailorSalary;
    String sailorDesignation;
    int count = 1;
    int c, x1, x2;
    Boolean[] blockedsailor = new Boolean[100];    //Array to know if a sailor has already been added to the cruise or not
  
    static ArrayList<Sailor> sailobj = new ArrayList<>(200); //Array list  to keep track of Sailors
 
    static double totalsalary = 0;

    public void Sailor() {
        for (int i = 0; i < 100; i++) {
            blockedsailor[i] = Boolean.FALSE;
        }
    }
/**
 * @param desig - Denotes the type of sailor object to be created
 * Sets sailor data according to the type of sailor and adds to the sailor array list
 * 
 */
    public void setData(int desig) {

        try {
            int scloop = 1;
            c = 1;
            BufferedReader in = new BufferedReader(new FileReader("Sail.txt"));
            String s;
            Random r1 = new Random();
            Random r2 = new Random();
            x1 = r1.nextInt(100 - 1) + 1;
            
            while (blockedsailor[x1] == Boolean.TRUE) { //Checks if a sailor has already been selected or not, if selected, reads another line from the sailor file
                //   System.out.println("Sailor No" + (x1 + 1) + " is blocked");
                x1 = r1.nextInt(100 - 1) + 1;
                conflict++;
            }

            
            while (scloop <= x1) {
                s = in.readLine();
                scloop++;
            }
            s = in.readLine();
            count++;
            StringTokenizer str = new StringTokenizer(s, "|"); //Tokenizes input string and allocated it to different attributes of sailor
            sailorNo = Integer.parseInt(str.nextElement().toString());
            sailorName = str.nextElement().toString();

            SimpleDateFormat sdfmt1 = new SimpleDateFormat("dd/MM/yyyy");

            sailorDob = sdfmt1.parse(str.nextElement().toString());

            sailorNationality = str.nextElement().toString();
            if (desig == 0) {

                Captain obj1 = new Captain(); //New captain object is created
                sailorSalary = 300000;
                obj1.sailorNo = this.sailorNo;
                obj1.sailorName = this.sailorName;
                obj1.sailorDob = this.sailorDob;
                obj1.sailorNationality = this.sailorNationality;
                sailorDesignation = "Captain";
                sailorSalary = 300000;
            } else if (desig == 3) {
                Sailors obj1 = new Sailors();  //New Sailor object is created with supervisor flag set to TRUE
                sailorSalary = 50000 * 1.2;
                obj1.sailorNo = this.sailorNo;
                obj1.sailorName = this.sailorName;
                obj1.sailorDob = this.sailorDob;
                obj1.sailorNationality = this.sailorNationality;
                obj1.sailorDesignation="Supervising Sailor";
                sailorDesignation = obj1.sailorDesignation;
                

            } else if (desig == 4) {
                Sailors obj1 = new Sailors();  //New Sailor object is created with supervisor flag set to FALSE
                sailorSalary = 50000;
                obj1.sailorNo = this.sailorNo;
                obj1.sailorName = this.sailorName;
                obj1.sailorDob = this.sailorDob;
                obj1.sailorNationality = this.sailorNationality;
                obj1.sailorDesignation="Sailor";
                sailorDesignation = obj1.sailorDesignation;
          

            } else if (desig == 2) {
                Engineer obj1 = new Engineer(); //New Enguneer object is created
                sailorSalary = 80000;
                obj1.sailorNo = this.sailorNo;
                obj1.sailorName = this.sailorName;
                obj1.sailorDob = this.sailorDob;
                obj1.sailorNationality = this.sailorNationality;
                sailorDesignation = "Engineer";
               
            } else if (desig == 1) {
                Cook obj1 = new Cook(); //New Cook object is created
                sailorSalary = 80000;
                obj1.sailorNo = this.sailorNo;
                obj1.sailorName = this.sailorName;
                obj1.sailorDob = this.sailorDob;
                obj1.sailorNationality = this.sailorNationality;
                sailorDesignation = "Cook";
               
            } else if (desig == 5) {
                Doctors obj1 = new Doctors(); //New Cook object is created
                sailorSalary = 80000;
                obj1.sailorNo = this.sailorNo;
                obj1.sailorName = this.sailorName;
                obj1.sailorDob = this.sailorDob;
                obj1.sailorNationality = this.sailorNationality;
                sailorDesignation = "Doctors";
                
            }

            blockedsailor[x1] = Boolean.TRUE; // Sailor is marked as alrady blocked to avoid repetition next time
            Sailor temp = new Sailor(); //Temporary Sailor object is created and added to the array list with currnt sailor's details
            temp.sailorNo = this.sailorNo; 
            temp.sailorName = this.sailorName;
            temp.sailorDob = this.sailorDob;
            temp.sailorNationality = this.sailorNationality;
            temp.sailorDesignation = this.sailorDesignation;
            temp.sailorSalary = this.sailorSalary;

                      
            sailobj.add(temp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   
/**
 *  Prints Sailor reports on the console, Has been made static to facilitate direct invocation from Report Generation Class
 */
    public static void sailorPrintData() {
        int i = 0;
        System.out.println("Sailor Data\n");
        System.out.printf("\n%-20s %-20s %-20s %-20s\n", "Sailor Name", "Nationality", "Salary", "Designation");
        while (sailobj.size() > i) {

            System.out.printf("%-20s %-20s %-20.2f %-20s\n", sailobj.get(i).sailorName, sailobj.get(i).sailorNationality, sailobj.get(i).sailorSalary, sailobj.get(i).sailorDesignation);
            totalsalary = totalsalary + sailobj.get(i).sailorSalary;
            i++;

        }

        System.out.println("\n\nTotal Money Spent for salary on this cruise " + totalsalary); //Calculates Total money Spent for salary on the cruise
        totalsalary = totalsalary + 10000;
    }

}
