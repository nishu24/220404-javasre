package com.ex.Repositories;

import com.ex.BankCustomer.BankCustomer;
import com.ex.BankCustomer.CustomerAccount;
import com.ex.Utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLRepository implements Repository<Integer, BankCustomer>{
    private DBConnector connector; //creating private DBConnector object

    public DBConnector getConnector() {  // Implementing getter and setter methods for connector
        return connector;
    }

    public void setConnector(DBConnector connector) {
        this.connector = connector;
    }

    public SQLRepository(DBConnector connector) {   // one-Args connector constructor
        this.connector = connector;
    }

    /** Creating array list for list of bank customers.
     * ResultSet objects created to store -bank customers, -customer's accounts, & their -transaction history.
     * @return
     */
    @Override
    public List<BankCustomer> getAll() {
        ArrayList<BankCustomer> bankCustomers = new ArrayList<BankCustomer>();
        ResultSet bankCustSet, bankCustAcctSet, bankCustTranHistSet;
        try(Connection conn= connector.getConnection())
        {
        String SQL="SELECT * from BankCustomer";
            PreparedStatement ps = conn.prepareStatement(SQL);
            bankCustSet=ps.executeQuery();
            while(bankCustSet.next()){
                ps=conn.prepareStatement(SQL+bankCustSet.getInt("id")+"");
                bankCustAcctSet=ps.executeQuery();
                ArrayList<CustomerAccount> accounts=createAccountList(bankCustAcctSet);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        } return bankCustomers;
    }

    private ArrayList<CustomerAccount> createAccountList(ResultSet bankCustAcctSet) {
        ArrayList<CustomerAccount> Accounts = new ArrayList<CustomerAccount>();
        //code for adding accounts from resultset until .next(), and then fetching balance & account name and return the list back.
        return Accounts;
    }

    @Override
    public Optional<BankCustomer> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Integer save(BankCustomer obj) {
        return null;
    }

    @Override
    public void update(BankCustomer obj) {

    }

    @Override
    public void delete(BankCustomer obj) {

    }
}
