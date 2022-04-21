package com.ex.DAO;

public class DAO {
    private int CustomerID;
    private int AccountID;
    private int ReceiverID;
    private float Balance;

    /**
     *This, DAO file acts as/is used to access data from database of data storage, DAO is used to abstract the retrieval
     * of data from a data source.
     * @param customerID
     * @param accountID
     * @param receiverID
     * @param balance
     */
    public DAO(int customerID, int accountID, int receiverID, float balance) {
        CustomerID = customerID;
        AccountID = accountID;
        ReceiverID = receiverID;
        Balance = balance;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public int getReceiverID() {
        return ReceiverID;
    }

    public void setReceiverID(int receiverID) {
        ReceiverID = receiverID;
    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float balance) {
        Balance = balance;
    }
}
