package com.console;

public class BankAccount {
    int amount=0; //Starting Balance of the user

    public void initiate(){
        Login l1 = new Login();
        try{
            l1.acceptInput(System.in);
            l1.verify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Method to get balance
    public int getBalance(){
        return amount;
    }
    //Method to Deposit
    public void deposit(int amt){
        amount=amount+amt;
        System.out.println("Amount is deposited, and your balance is " +amount);
    }
    //Method to withdraw
    public void withDraw(int amt){
        if(amt>amount){
            System.out.println("Invalid amount, withdrawal cannot be more than your balance");
        }else{
            amount = amount-amt;
            System.out.println("Your Money is Dispatched at collection $" +amt+"\n");
            System.out.println("Available balance is :$" +amount+"\n");

        }
    }
}

