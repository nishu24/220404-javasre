package com.console;

import java.util.Scanner;

public class CustomerFunctions {
    BankAccount ba = new BankAccount();
    int option;
    public void DisplayOptions(){
        System.out.println("Please Select an Option to Continue\n " +
                "Deposit Select:1\n Make a Withdrawal:2\n To View Your Balance:3\n Or Press Any Key to Exit\n  ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Your Option");
        option=scanner.nextInt();
        switch (option) {
            case 1:
                deposit d = new deposit();
                int deAmt = d.userInput();
                ba.deposit(deAmt); // Depositing amount to the Account
                DisplayOptions(); break;
            case 2:
                System.out.println("Enter you amount to withdraw");
                int withDrawAmt = scanner.nextInt();
                ba.withDraw(withDrawAmt);
                DisplayOptions(); break;
            case 3:
                System.out.println("Your Account balance is $"+ba.getBalance());
                DisplayOptions(); break;
            default:
                System.out.println("Your Transaction has Ended, Your will now be logout! Thank you");
                System.exit(0);
                break;

        }
    }

    public class deposit{
        int amt=0;
        public int userInput(){
            System.out.println("Enter amount you want to deposit");
            Scanner scanner1 = new Scanner(System.in);
            amt=scanner1.nextInt();
            if(amt<=0){
                System.out.println("Invalid Deposit Amount");
            }else {
                return amt;
            }
            return amt;
        }
    }
}

