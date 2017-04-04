/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package narnia;

import java.util.Date;

/**
 * Derived class of Sailors- manages supervisors and sailors
 * @author sharanya
 */
public class Sailors extends Sailor {
    
  boolean supervisor;
  /**
   * constructor sets sailor designation and also the supervisor flag to  indicate if he is a supervisor or not
   * @param x 
   */
    public void Sailors(int x)
    {
        
      
        if(x==1) {sailorDesignation="Supervising Sailor";
        sailorSalary=50000*1.2;
        supervisor=Boolean.TRUE;
        
        
        }
        else
        {
            sailorDesignation="Sailor";
        sailorSalary=50000;
         supervisor=Boolean.FALSE;
        }
    }
    
}
