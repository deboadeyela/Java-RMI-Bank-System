


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gbadebo
 */
import java.io.*;
import java.util.*;


public class Statement implements Serializable  {
   ArrayList<Transaction> transactions = new ArrayList();
   String accName;
   Long accNum;
   
   public void setAccountName(String accName){
       this.accName =accName;
      
   }
   
   public void setAccountNum(long accNum){
    this.accNum = accNum;
}
    
public Long getAccountnum(){
   
    return accNum;
}// returns account number associated with this statement

public Date getStartDate(){
    return transactions.get(0).date;
} 
public Date getEndDate(){
    return transactions.get(transactions.size()-1).date;
} // returns end Date of Statement

public String getAccoutName(){
   return accName;
}

// returns name of account holder
public List<Transaction> getTransactions(){
    return transactions;
 
}

@Override
public String toString(){
    

        return accName + " " + accNum + "\n"+transactions.toString();


  //  return  accName + " " + accNum + "\n"+ transactions.toString();
}
}