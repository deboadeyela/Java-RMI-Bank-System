/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gbadebo
 */

import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Account implements Serializable{
    
     BigDecimal balance;
     int accnum;
     String username;
     String password;
    Statement statement;
   
     
     public Account(BigDecimal balance, int accnum, String username, String password) {
         this.balance=balance;
         this.accnum=accnum;
         this.username=username;
         this.password=password;
          statement = new Statement();
          statement.setAccountName(username);
         statement.setAccountNum(accnum);
          
     }
    
    public BigDecimal getBalance(){
        return balance;
    }
    
    public long getAccountNum(){
        return accnum;
    }
     
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}
