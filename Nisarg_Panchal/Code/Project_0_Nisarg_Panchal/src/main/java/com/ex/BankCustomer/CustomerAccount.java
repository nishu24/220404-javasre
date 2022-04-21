package com.ex.BankCustomer;

public class CustomerAccount {
    private String name;
    private float balance;
    /** This class is customer's account, which have customer's name (String) and their balance in (float)
     *
     * @param balance
     * @param name
     */
    public CustomerAccount(float balance, String name) {
        this.name = name;
        this.balance = balance;
    }

    public CustomerAccount() {
    }

    public String getName() {
        return name;
    }

    /**Implementing toString Methods
     *
     * @return
     */
    @Override
    public String toString() {
        return "CustomerAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
