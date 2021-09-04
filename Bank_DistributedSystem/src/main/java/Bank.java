/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gbadebo
 */

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Bank implements BankInterface {
    ArrayList<Account> accounts = new ArrayList(); 
 ArrayList<String> auth= new ArrayList();
long sID = 0;

//private ArrayList<Transaction> transactions = new ArrayList();
//private Statement statement = new Statement();
//private ArrayList<Statement> statements = new ArrayList();
public Bank() throws RemoteException
{
}
public long login(String username, String password) throws RemoteException, InvalidLogin{
     
    //if(accounts.contains(username)&& accounts.contains)
    for(int i=0;i<accounts.size();i++){
        auth.add(accounts.get(i).getUsername()+ accounts.get(i).getPassword());
    }
    if( !auth.contains(username+password))
        throw new InvalidLogin("user was not found");
    else 
       
        sID = (long)Math.random()*(10000)+1;
    
    return sID;
}

public void deposit(int account, BigDecimal amount,long sessionID) throws RemoteException, InvalidSession, ParseException  {

if(sessionID != sID || sID == 0){
    throw new InvalidSession("invalid session");
}else{
     
Date date = new Date();
 //date=new SimpleDateFormat("dd/MM/yyyy").parse(17122020);
 SimpleDateFormat formatter = new SimpleDateFormat(
      "dd/MM/yyyy");
    Date d1 = formatter.parse(formatter.format(date));


 for (Account acc : accounts) {
        if (acc.getAccountNum() == account) {
            acc.statement.transactions.add(new Transaction("deposit",amount,d1));
            acc.balance = acc.balance.add(amount);
        }
    }
 /*
if(accounts.indexOf(account) != -1){
    accounts.get(accounts.indexOf(account)).statement.transactions.add(new Transaction("deposit",amount,date));
    accounts.get(accounts.indexOf(account)).balance = accounts.get(accounts.indexOf(account)).balance.add(amount);
}

for( int i=0;i<accounts.size();i++){
    if(account == accounts.get(i).accnum){
        accounts.get(i).statement.transactions.add(new Transaction("deposit",amount,date));
       
accounts.get(i).balance = accounts.get(i).balance.add(amount);
    }
}*/
}
}
public void withdraw(int account, BigDecimal amount,long sessionID) throws RemoteException, InvalidSession, ParseException  {
if(sessionID != sID || sID == 0){
    throw new InvalidSession("invalid session");
}else{
Date date = new Date();


SimpleDateFormat formatter = new SimpleDateFormat(
      "dd/MM/yyyy");
    Date d1 = formatter.parse(formatter.format(date));
/*
for( int i=0;i<accounts.size()-1;i++){
    if(account == accounts.get(i).accnum){
         
        accounts.get(i).statement.transactions.add(new Transaction("withdraw",amount,d1));
accounts.get(i).balance = accounts.get(i).balance.subtract(amount);
    }
}
*/
for (Account acc : accounts) {
        if (acc.getAccountNum() == account) {
            acc.statement.transactions.add(new Transaction("withdraw",amount,d1));
            acc.balance = acc.balance.add(amount);
        }
    }

}
}
public BigDecimal getBalance(int account, long sessionID) throws RemoteException, InvalidSession {
    
if(sessionID != sID || sID == 0){
    throw new InvalidSession("invalid session");
}else{
BigDecimal balance = null;
for( int i=0;i<accounts.size()-1;i++){
    if(account == accounts.get(i).accnum){
balance = accounts.get(i).balance;
    }
}
return balance;
}
}

public Statement getStatement(int account,Date from, Date to,long sessionID) throws RemoteException, InvalidSession {
// implementation code
if(sessionID != sID || sID == 0){
    throw new InvalidSession("invalid session");
}else{
    Statement statement = new Statement();
    for(int i=0;i<accounts.size();i++){
        if(account == accounts.get(i).accnum){
      for(int j=0; j< accounts.get(i).statement.transactions.size();j++){
            if (accounts.get(i).statement.transactions.get(j).getDate().after(from)
                    && accounts.get(i).statement.transactions.get(j).getDate().before(to)) {
                statement.transactions.add(accounts.get(i).statement.transactions.get(j));
            }
        }
        }
    }
    
    
    return statement;
}
}

public void populate()throws RemoteException{
   
double a1 = 10.00;
double a2 = 12.54;
double a3 = 15.50;

Account ac1 = new Account(BigDecimal.valueOf(a1),1,"pat","123");
Account ac2 = new Account( BigDecimal.valueOf(a2),2,"michael","456");
Account ac3 = new Account( BigDecimal.valueOf(a3),3,"sharon","789");

 
accounts.add(ac1);
accounts.add(ac2);
accounts.add(ac3);
    
}
public static void main(String args[]) throws Exception {
// initialise Bank server - see sample code in the notes and online RMI tutorials for details


      
//accounts.add()
try
    {
 
      // First reset our Security manager
      if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
            System.out.println("Security manager set");
        }
      // Create an instance of the local object
      BankInterface bankserver = new Bank();
      System.out.println("Instance of Bank Server created");
      BankInterface stub = (BankInterface) UnicastRemoteObject.exportObject(bankserver, 0);
      
      // Put the server object into the Registry
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind("Bank", stub);
      System.out.println("Name rebind completed");
      System.out.println("Server ready for requests!");
    }
catch(Exception exc)
    {
      System.out.println("Error in main - " + exc.toString());
    }
}
}
