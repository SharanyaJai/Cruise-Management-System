/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narnia;

import java.util.Random;

/**
 *
 * @author sharanya
 */public class Emp {
    java.util.Date date;

   /* public void setId(int id) {
        this.id = id;
    }
   
    @Override
    public int hashCode() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean equals(Emp obj) {
        return this.id==obj.id
                ; //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Emp e1 = new Emp();
        e1.setId(1);
         Emp e2 = new Emp();
        e2.setId(2);
        
        System.out.println(e1.equals(e2));
    }
    */
    public static void main(String[] args) {
        Emp test=new Emp();
        
        Random r= new Random();
       int i=r.nextInt(26-1)+97;
        System.out.println(i);
    }
    
    
}
