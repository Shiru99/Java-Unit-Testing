package io.fall.exceptions;

public class AccountNotFoundException extends Exception  
{  
    public AccountNotFoundException()  
    {  
        // calling the constructor of parent Exception  
        super("\nAccount Not Found. please add valid credentials");  
    }  
} 
