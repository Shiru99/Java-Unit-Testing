package io.fall.exceptions;

public class InsufficientBalanceException extends Exception  
{  
    public InsufficientBalanceException()  
    {  
        // calling the constructor of parent Exception  
        super("\nInsufficient Balance. your account doesn't have sufficient balance");  
    }  
} 
