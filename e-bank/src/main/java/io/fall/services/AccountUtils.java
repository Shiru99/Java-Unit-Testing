package io.fall.services;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import io.fall.exceptions.AccountNotFoundException;
import io.fall.exceptions.InsufficientBalanceException;
import io.fall.exceptions.InvalidAccountException;
import io.fall.models.Account;


/**
 * singleton class
 */
public class AccountUtils implements Operations {

    // Singleton class instance
    private static AccountUtils accountUtils = null;

    private AccountUtils(){ }

    public static AccountUtils getInstance(){
        if(accountUtils==null) accountUtils = new AccountUtils();
        return accountUtils;
    }

    Map<Integer,Account> allAccounts = new TreeMap<>();

    static int accountsCreatedSoFar = 0;

    @Override
    public boolean addAccount(Account account) 
    {
        
        // Valid account added to allAccounts list
        try {
            if(account.validateAccount())
                {
                    account.setAccNumber(++accountsCreatedSoFar);
                    allAccounts.put(accountsCreatedSoFar, account);
                    System.out.println(accountsCreatedSoFar+" account created successfully");
                    System.out.println("\nAccount added successfully...");
                    
                    System.out.println(account);
                }
        } catch (InvalidAccountException | InsufficientBalanceException e) {
            System.out.println("Exception occurred: " + e);  
            return false;
        }
        return true;
    }

    @Override
    public boolean displayAccount(int accNumber) 
    {
        try {
            System.out.println(searchAccountByAccountNumber(accNumber).toString()); 
            return true;
        } catch (AccountNotFoundException e) {
            System.out.println("Exception occurred: " + e);  
            return false;
        } 
    }

    @Override
    public void displayAllAccounts() 
    {    
        for (Entry<Integer,Account> entry : allAccounts.entrySet())
            System.out.println(entry.getValue().toString()+"\n");
    }

    @Override
    public boolean removeAccountByEmail(String email) {
        Account accountToRemove = searchAccountByEmail(email);
        if(accountToRemove!=null){
            allAccounts.remove(accountToRemove.getAccNumber());
            System.out.println("Account removed successfully...");
            return true; 
        }else{
            return false;
        }
    }

    @Override
    public boolean withdrawMoney(int accNumber, double amount) {
        try 
        {
            Account inTransitionAccount = searchAccountByAccountNumber(accNumber);

            inTransitionAccount.setBalance(inTransitionAccount.getBalance()-amount);

            try 
            {
                if(inTransitionAccount.validateAccount())
                    {allAccounts.replace(inTransitionAccount.getAccNumber(), inTransitionAccount);
                        System.out.println("Amount withdrawal successful...");
                    }
            } catch (InvalidAccountException | InsufficientBalanceException e) 
            {
                System.out.println("Exception occurred: " + e);  
                return false;
            }

            return true;
        } 
        catch (AccountNotFoundException e) 
        {
            System.out.println("Exception occurred: " + e);  
            return false;
        } 
    }

    @Override
    public boolean depositMoney(int accNumber, double amount) {
        try 
        {
            Account inTransitionAccount = searchAccountByAccountNumber(accNumber);
            inTransitionAccount.setBalance(inTransitionAccount.getBalance()+amount);
            allAccounts.replace(inTransitionAccount.getAccNumber(), inTransitionAccount);
            System.out.println("Amount deposited successfully...");
            return true;
        } 
        catch (AccountNotFoundException e) 
        {
            System.out.println("Exception occurred: " + e);  
            return false;
        } 
    }

    @Override
    public boolean transferMoney(int accNumber1, int accNumber2, double amount) {
        try 
        {
            Account inTransitionAccount1 = searchAccountByAccountNumber(accNumber1);
            Account inTransitionAccount2 = searchAccountByAccountNumber(accNumber2);

            inTransitionAccount1.setBalance(inTransitionAccount1.getBalance()-amount);
            inTransitionAccount2.setBalance(inTransitionAccount2.getBalance()+amount);

                try {
                    if(inTransitionAccount1.validateAccount()){
                        allAccounts.replace(inTransitionAccount1.getAccNumber(), inTransitionAccount1);
                        allAccounts.replace(inTransitionAccount2.getAccNumber(), inTransitionAccount2);
                        System.out.println("Amount transferred successfully...");
                    }
                } catch (InsufficientBalanceException | InvalidAccountException e) {
                    System.out.println("Exception occurred: " + e);  
                }
            

            return true;
        } 
        catch (AccountNotFoundException e) 
        {
            System.out.println("Exception occurred: " + e);  
            return false;
        } 
    }

    @Override
    public Account searchAccountByAccountNumber(int accNumber) throws AccountNotFoundException {
        
        if(allAccounts.containsKey(accNumber)){
            return allAccounts.get(accNumber);
        }

        throw new AccountNotFoundException();
    }

    @Override
    public Account searchAccountByName(String name) {
        
        for (Entry<Integer,Account> entry : allAccounts.entrySet()) {
            if(entry.getValue().getName().equals(name)){
                return entry.getValue();
            }
        }

        try {
            throw new AccountNotFoundException();
        } catch (AccountNotFoundException e) {
            System.out.println("Exception occurred: " + e);  
        }
        return null;
    }

    @Override
    public Account searchAccountByEmail(String email) {
        
        for (Entry<Integer,Account> entry : allAccounts.entrySet()) {
            if(entry.getValue().getEmail().equals(email)){
                return entry.getValue();
            }
        }

        try {
            throw new AccountNotFoundException();
        } catch (AccountNotFoundException e) {
            System.out.println("Exception occurred: " + e);  
        }
        return null;
    }

    @Override
    public Account searchAccountByPhone(String phone) {
        
        for (Entry<Integer,Account> entry : allAccounts.entrySet()) {
            if(entry.getValue().getPhone().equals(phone)){
                return entry.getValue();
            }
        }

        try {
            throw new AccountNotFoundException();
        } catch (AccountNotFoundException e) {
            System.out.println("Exception occurred: " + e);  
        }
        return null;
    }
    
}
