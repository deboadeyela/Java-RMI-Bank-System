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
import java.util.*;
import java.math.BigDecimal;
import java.text.ParseException;


public interface BankInterface extends Remote {
// The login method returns a token that is valid for some time period that must be passed to the other methods as a session identifier
public long login(String username, String password) throws RemoteException, InvalidLogin ;
public void deposit(int accountnum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession, ParseException ;
public void withdraw(int accountnum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession,ParseException ;
public BigDecimal getBalance(int accountnum, long sessionID) throws RemoteException, InvalidSession;
public Statement getStatement(int account,Date from, Date to, long sessionID) throws RemoteException, InvalidSession;
public void populate()throws RemoteException;
}
