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
import java.util.StringTokenizer;

/**
 * Manages Port of call
 * @author sharanya
 */
public class Port {

     String portName;
    String portCountry;
    int portPopulation;
     String passportRequirement;
     float portDockingfees;
     int count = 1;
    int c = 1;
     static ArrayList<Port> portobj = new ArrayList<Port>(300);
     /** Sets port objects values
      * 
      * @param q - capacity of Ship is used to determine the docking fees in each port of call 
      */

    public void setData(int q) {
        try {

            c = 1;
            BufferedReader in = new BufferedReader(new FileReader("Port.txt"));
            String s;
            s = in.readLine();
            while (c <= count) {
                s = in.readLine();
                c++;
            }
          

            count++;
            StringTokenizer str = new StringTokenizer(s, "|"); // read input stream from random line on Port.txt file and alloctaes data to each of the port object attributes         
            portName = str.nextElement().toString();
            portCountry = str.nextElement().toString();
          portPopulation = Integer.parseInt(str.nextElement().toString());
            int v=Integer.parseInt(str.nextElement().toString());
            if(v==1)
            passportRequirement = "Yes";
            else 
                passportRequirement="No";

           if(q<=30000)
               portDockingfees=20000;
           else if (q>30000 && q<=50000)
                portDockingfees=50000;
           else if (q>50000)
               portDockingfees=1000000;
           Port temp = new Port();  //Creates a temporrary port object and adds each port to the arraylist of ports to keep track of lit
            
            temp.portName = this.portName;
            temp.portCountry = this.portCountry;
            temp.portPopulation = this.portPopulation;
            temp.portDockingfees = this.portDockingfees;
            temp.passportRequirement = this.passportRequirement;
            portobj.add(temp);//adds each port object to array list of ports
          
          

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Displays List of ports and their values on the console, Has been made static to facilitate direct invocation from Report Generation Class
     */
    static public void displayPorts()
    { int i=0;
    System.out.println("\nPorts Data\n");
        System.out.printf("\n%-20s %-20s %-20s %-20s %-20s\n","Port Name", "Country","Docking Fees","Population","Passport Requirement");
       
        while(i<portobj.size())
        {
            System.out.printf("%-20s %-20s %-20.2f %-20d %-20s\n", portobj.get(i).portName,portobj.get(i).portCountry,portobj.get(i).portDockingfees, portobj.get(i).portPopulation,portobj.get(i).passportRequirement);
           i++;
        }
    }
}
