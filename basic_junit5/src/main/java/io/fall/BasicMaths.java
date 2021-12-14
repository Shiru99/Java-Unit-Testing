package io.fall;

public class BasicMaths {

    public int addition(int a,int b) {
        return a+b;
    }

    public int subtraction(int a,int b) {
        return a-b;
    }

    public int multiplication(int a,int b) {
        return a*b;
    }

    public int division(int a,int b) {
        if(b==0) throw new ArithmeticException("Zero cannot divide any number");
        return a/b;
    }
}
