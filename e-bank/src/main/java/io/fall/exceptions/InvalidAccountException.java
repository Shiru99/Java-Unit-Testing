package io.fall.exceptions;

public class InvalidAccountException extends Exception  
{  
    public InvalidAccountException()  
    {  
        // calling the constructor of parent Exception  
        super(
            "\nInvalid Account Details. please add valid account details"+
            "\n\t Name : name should be more than 5 chars"+
            "\n\t Email : email should contain '@'"+
            "\n\t Phone : phone should be 10 digits"
        );  
    }  
} 
