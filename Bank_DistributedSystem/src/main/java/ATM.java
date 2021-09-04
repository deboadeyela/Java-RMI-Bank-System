
import java.rmi.*;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gbadebo
 */
public class ATM {
public static void main (String args[]) throws Exception {
try {

String operation;
operation = args[0];





BankInterface bank = (BankInterface) Naming.lookup("//localhost/Bank");
 

if  (operation.equals("login")){
  try {
    String username = args[1];
    String password = args[2];

   
    long sesID = bank.login(username, password);
 
  System.out.printf("Successful login for"+username+"\n sessionID:"+ sesID);

    } catch(Exception e)
    {
      
      System.out.println("Error when logging into account");
      return;
    }
 
 }

else if (operation.equals("deposit")){
 try {
   Integer account = Integer.parseInt(args[1]);
   long sesID = Long.parseLong(args[2]);
   

   BigDecimal amount = new BigDecimal(args[3]);
 
   
   
   bank.deposit(account ,amount, sesID);
 
 System.out.printf("Successfully deposited $" + amount+" into account "+account);

   } catch(Exception e)
   {
     System.out.println("Error when deposting into account-" + e);
     return;
   }
 
}
else if (operation.equals("populate")){
    try{
        bank.populate();
         System.out.println("success");
    }catch(Exception e)
   {
     System.out.println("Error when creating accounts - "+ e);
     return;
   }
    
}

 else if (operation.equals("withdraw")) {
   try {
     
     Integer account = Integer.parseInt(args[1]);
     
       long sID = Long.parseLong(args[2]);
      BigDecimal amount = new BigDecimal(args[3]);
      
     bank.withdraw(account,amount, sID);
     System.out.printf("Successfully withdrew $" + amount+" into account "+account);

   } catch(Exception e)
   {
     System.out.println("Error when withdrawing into account-"+ e);
     return;
   }
   }

 else if (operation.equals("balance")) {
  try {
    Integer account = Integer.parseInt(args[1]);
    //BigDecimal amount = new BigDecimal(args[4]);
 
   long sesID = Long.parseLong(args[2]);
   
   BigDecimal balance = bank.getBalance(account, sesID);
    System.out.printf("The balance for account "+ account+"is $" + balance);
  } catch(Exception e)
  {
    System.out.println("Error providing balance for account - " + e);
    return;
  }
  }

 else if (operation.equals("statement")) {
   try {
     Integer account = Integer.parseInt(args[1]);
     long sesID = Long.parseLong(args[2]);
     String fromDate = args[3];
     String toDate = args[4];
 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);  
 Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse(toDate);
     
     

     Statement state = bank.getStatement(account,date1,date2, sesID);
     System.out.printf(state.toString());
   } catch(Exception e)
   {
     System.out.println("Error providing statement for account" + e);
     return;
   }
   }

 else
 {
   System.out.println("Operation Not Defined:"+operation);
   return;
}
} catch (Exception e) {
  System.out.println ("bankClient exception: " + e);
}
}
}
