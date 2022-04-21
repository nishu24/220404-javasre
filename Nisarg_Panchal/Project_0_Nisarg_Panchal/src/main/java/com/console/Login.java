package com.console;


import java.io.InputStream;
import java.util.Scanner;

public class Login {
    int ac_no = 123456;
    int ac_pw= 777777;
    int ac, pw;



    public int acceptInput(InputStream in){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your NP Bank account number");
        ac=scanner.nextInt();
        System.out.println("Enter Your Password for the account");
        pw=scanner.nextInt();
        return 0;
    }
    public void verify() throws Exception{
        if(ac==ac_no && pw==ac_pw){
            System.out.println("Your NP Bank Login is Successfully accepted");
            BankAccount ba = new BankAccount();
            System.out.println("Your Account balance is: $"+ba.getBalance()+"\n");
            CustomerFunctions cf = new CustomerFunctions();
            cf.DisplayOptions();
        }else{
            System.out.println("Invalid Credentials Found");
        }
    }
}



