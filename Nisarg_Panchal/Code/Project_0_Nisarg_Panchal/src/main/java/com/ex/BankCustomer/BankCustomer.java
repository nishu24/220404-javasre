package com.ex.BankCustomer;
import com.ex.GeneralUser.AnyUser;
import sun.java2d.loops.XORComposite;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BankCustomer extends AnyUser {
    // According to Req: we need to have credit score of a user to assess credit
    //private ArrayList<CustomerAccount> accounts;
    /** This is a class for Bank Customers, extending from the general users' class.
     *  Here, bank's customer will have their credit score, list of accounts and their transaction history
     */
    private int CreditScore;
    private ArrayList<CustomerAccount> accounts;
    private ArrayList<String> transactionHistory;

    /** Setting up toString methods
     *
     * @return
     */
    @Override
    public String toString() {
        return "BankCustomer{" +
                "CreditScore=" + CreditScore +
                ", accounts=" + accounts +
                ", transactionHistory='" + transactionHistory + '\'' +
                '}';
    }

    public BankCustomer(){

    }
    public BankCustomer(String username, String password){
        super(username, password);
        this.accounts = new ArrayList<CustomerAccount>();
        this.transactionHistory = new ArrayList<String>();
        int anynumber = ThreadLocalRandom.current().nextInt();
        this.CreditScore=anynumber+350;
    }

    /**
     *
     * @param username
     * @param password
     * @param accounts
     */
    public BankCustomer(String username, String password, ArrayList<CustomerAccount>accounts){
        super(username, password);
        this.accounts=accounts;
        this.transactionHistory = new ArrayList<String>();
        int anynumber = ThreadLocalRandom.current().nextInt();
        this.CreditScore=anynumber+350;
    }

    public BankCustomer(String username, String password,int creditScore, ArrayList<CustomerAccount> accounts)
    {
        super(username, password);
        this.accounts = accounts;
        this.CreditScore = creditScore;
        this.transactionHistory = new ArrayList<String>();
    }

    public BankCustomer(String username, String password, ArrayList<CustomerAccount> accounts, int creditScore, ArrayList<String> transactionHistory) {
        super(username, password);
        this.accounts = accounts;
        this.CreditScore = creditScore;
        this.transactionHistory = transactionHistory;
    }

    public ArrayList<CustomerAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<CustomerAccount> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ArrayList<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public int getCreditScore() {
        return CreditScore;
    }

    public void setCreditScore(int creditScore) {
        this.CreditScore = creditScore;
    }

}
