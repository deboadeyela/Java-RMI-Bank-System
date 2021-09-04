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
import java.math.BigDecimal;

public class Transaction implements Serializable {
// Needs some accessor methods to return information about the transaction


public String description;
public BigDecimal amount;
public Date date;

public Transaction(String description,BigDecimal amount, Date date){
    this.description=description;
    this.amount=amount;
    this.date=date;
}

public BigDecimal getAmount(){
    return amount;
}

public Date getDate(){
    return date;
}

@Override
public String toString(){
    return "type: "+description +" amount: "+ getAmount()+" Date: "+ getDate()+"\n" ;
}
}
