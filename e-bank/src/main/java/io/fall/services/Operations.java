package io.fall.services;

import io.fall.exceptions.AccountNotFoundException;
import io.fall.exceptions.InvalidAccountException;
import io.fall.models.Account;

public interface Operations {

    /**
     * Add new {@Account} 
     * 
     * @param account
     * @return boolean, true if add is successful else false
     * @throws InvalidAccountException
     **/
    boolean addAccount(Account account) throws InvalidAccountException;


    /**
     * Display {@Account} Details
     * 
     * @param accNumber
     * @return boolean, true if account exists else false
     **/
    boolean displayAccount(int accNumber);


    /**
     * Display each {@Account} details from the list
     **/
    void displayAllAccounts();


    /**
     * Remove {@Account} from the list of a given email id
     *
     * @param email
     * @return boolean, true if remove is successful else false
     **/
    boolean removeAccountByEmail(String email);


    /**
     * Withdraw money from {@Account.balance}}
     * 
     * @param accNumber  
     * @param amount
     * @return boolean, true if withdraw is successful else false
     **/
    boolean withdrawMoney(int accNumber, double amount);


    /**
     * Deposit money to {@Account.balance}
     * 
     * @param accNumber  
     * @param amount
     * @return boolean, true if deposit is successful else false
     **/
    boolean depositMoney(int accNumber, double amount);


    /**
     * Transfer money from {@Account.balance} to {@Account.balance}
     * 
     * @param accNumber1
     * @param accNumber2
     * @param amount
     * @return boolean, true if transfer is successful else false
     **/
    boolean transferMoney(int accNumber1, int accNumber2, double amount);

    /**
     * Search function searches {@Account} with account Number
     * 
     * @param accNumber
     * @return {@Account}, if search is successful else false
     * @throws AccountNotFoundException
     **/
    Account searchAccountByAccountNumber(int accNumber) throws AccountNotFoundException;

    /**
     * Search function searches {@Account} with given name
     * 
     * @param name
     * @return {@Account}, if search is successful else false
     * @throws AccountNotFoundException
     **/
    Account searchAccountByName(String name) throws AccountNotFoundException;

    /**
     * Search function searches {@Account} with given email id
     * 
     * @param email
     * @return {@Account}, if search is successful else false
     * @throws AccountNotFoundException
     **/
    Account searchAccountByEmail(String email) throws AccountNotFoundException;


    /**
     * Search function searches {@Account} with given phone
     * 
     * @param phone
     * @return {@Account}, if search is successful else false
     * @throws AccountNotFoundException
     **/
    Account searchAccountByPhone(String phone) throws AccountNotFoundException;

}