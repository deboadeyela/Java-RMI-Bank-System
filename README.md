# Java-RMI-Bank-System
This application implements a Distributed Banking System that consists of a server and some simulated Automated Teller Machine (ATM) clients. The server manages all users’ account information. A customer can invoke the following operations at an ATM client.

1. void deposit(int accnum, Money amt): this operation increases the balance of user account accnum by amt, and returns nothing
2. withdraw(int accnum, Money amt): this operation decreases the balance of user account accnum by amt, and returns nothing
3. Money getBalance(int accnum): this operation returns the balance of user account accnum
4. Statement getStatement(int accnum, Date from, Date to): this operation returns an account statement object encapsulating transactions over a time period

This client-server (banking system) application communicates via Java RMI.The program consists of two parts: one for the client and another for the server. The client (as the ATM) initiates an operation by calling a remote method on the bank server to execute a specified procedure (e.g. deposit) with parameters. The Joda-Money library class Money is used as the type for the Money parameter used in the various operations.

The command line parameters of the ATM client application includes:
1. operation: one of "login", "deposit", "withdraw", and "balance"
2. account: the user account
3. username: only for "login" operation
4. password: only for "login" operation
5. amount: only for “deposit” and “withdraw” operations

The ATM client application can be run at the command line using the parameters shown. The first operation that is called is login and if this succeeds a session ID is returned which is then valid for some predefined time period. This session ID then acts as an authentication token that must be passed for each of the other remote methods
