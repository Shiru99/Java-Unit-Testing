
package io.fall.models;

import io.fall.exceptions.InsufficientBalanceException;
import io.fall.exceptions.InvalidAccountException;

public class Account {

    private int accNumber;
    private String name;
    private String email;
    private String phone;
    private double balance;

    public Account(){ }

    public Account( String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = 100;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void transfer(Account account, double amount) {
        this.balance -= amount;
        account.balance += amount;
    }

    /**
     * Account Details
     */
    public String toString() {
        return "Account Details: "+"\n\t"+"Account Number: " + this.accNumber + "\n\t" + "Name: " + this.name + "\n\t" + "Email: " + this.email + "\n\t" + "Phone: " + this.phone + "\n\t" + "Balance: " + this.balance;
    }

    /**
     * @return boolean, true if {@account} is valid else false
     * @throws InsufficientBalanceException
     */
    public boolean validateAccount() throws InvalidAccountException, InsufficientBalanceException {

        // Name should be more than 5 chars
        if (this.getName().trim().length() < 5)
            throw new InvalidAccountException();

        // email should contain '@'
        if(!this.getEmail().contains("@")){
            throw new InvalidAccountException();
        }

        // phone should be of 10 digits
        if(this.getPhone().length() != 10){
            throw new InvalidAccountException();
        }

        // balance should be more than 100
        if (this.getBalance() < 100) {
            throw new InsufficientBalanceException();
        }

        return true;
    }
}