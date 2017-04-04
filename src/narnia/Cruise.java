/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narnia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import static narnia.Passengers.passengerobj;

/**
 * Simulates the cruise
 *
 * @author sharanya
 */
public class Cruise {

    static int cruiseno;

    static Ship cruiseship;
    static String startdate;
    static String enddate;

    static Port[] portofCall;

    /**
     * Creates a Cruise, Calls the Ship class methods, Calls the setPorts method, calls the Report Class methods to generate reports and Prints the Cruise Details to Text File
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException 
     */
    void createCruise() throws FileNotFoundException, IOException, ParseException {
        cruiseship = new Ship();
        cruiseship.setData();
        cruiseship.setSailor();
        cruiseship.setPassengers();
        Random r = new Random();

        cruiseno = r.nextInt(200 - 100) + 101; //generates random number for Cruise No
        int x1 = r.nextInt(100 - 1) + 1;
        BufferedReader in = new BufferedReader(new FileReader("CruiseDate.txt")); //Reads Cruise dates form the text file
        int scloop = 1;
        String s;
        while (scloop <= x1) {
            s = in.readLine();
            scloop++;
        }
        s = in.readLine();
        StringTokenizer str = new StringTokenizer(s, "|"); //Read Dates, tokenizes and sets the start and end value of dates

        startdate = str.nextElement().toString();
        enddate = str.nextElement().toString();

    }

    /**
     * Sets Ports and maintains the list  of ports of calls- calls Port class method
     */
   public void  setPorts() {
        Random r = new Random();

        portofCall = new Port[r.nextInt(10 - 1) + 5];
        Port p = new Port();
        for (int i = 0; i < portofCall.length; i++) {
            p.setData(cruiseship.shipCapacity);
            portofCall[i] = p;
        }
    }
/**
 * Calls reportGenerationMethod of Reports class to print reports
 * @throws IOException 
 */
    static void displayData() throws IOException {
        Reports reports = new Reports();
        reports.reportGeneration();

    }
/**
 * Prints Cruise details to CruiseReports.txt file
 * @throws FileNotFoundException
 * @throws IOException 
 */
    static public void cruisePrint() throws FileNotFoundException, IOException {
        File file = new File("CruiseReports.txt");
        boolean append = true;
        BufferedWriter pout = new BufferedWriter(new FileWriter(file, append));
        PrintWriter out = new PrintWriter(pout);
        out.println();
        Date today = new Date();
        out.write("\n\n");

        out.write("\nThis application was run on: " + today + "\n");
        out.println();
        out.printf("\n%-20s %-30s %-20s %-20s %-10s %-10s %-10s\n", "Cruiseno", "ShipName", "Start Date", "End date", "NoofPorts", "Noof Sailors", "NoofPassengers");
        out.println();
        out.printf("\n%-20d %-30s %-20s %-20s %-10d %-10d %-10d\n", cruiseno, cruiseship.shipName, startdate, enddate, portofCall.length, Ship.noofSailors, Ship.noofPassengers);
        out.println();
        out.write("\n Passenger Details\n");
        out.println();
        out.printf("%-20s %-30s %-20s %-20s\n", "Passenger No", "Passenger Name", "Nationality", "DOB");
        int k = 0;
        while (k < Passengers.passengerobj.size()) {
            out.printf("%-20d %-30s %-20s %-20s\n", passengerobj.get(k).passNo, passengerobj.get(k).passName, passengerobj.get(k).passNationality, passengerobj.get(k).passDob);
            //out.write("\n"+Passengers.passengerobj.get(i).passNo+"  "+Passengers.passengerobj.get(i).passName+ "  "+ Passengers.passengerobj.get(i).passengerdateofbirth+"\n");
            k++;
            out.println();
        }
        out.flush();
        out.close();
    }
}
