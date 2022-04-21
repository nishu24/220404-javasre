package com.ex.BankEmployee;
//According to Req: Bank Emp should be able to Create/Open accounts for Bank Customers

import com.ex.BankCustomer.BankCustomer;
import com.ex.BankCustomer.CreditApproval;
import com.ex.GeneralUser.AnyUser;

public class BankEmployee extends AnyUser {
    /**A general Bank Employee class, that should create a new bank customer.
     * Also implementing a method for checking credit requests/approvals from the CreditApproval.java class.
     */
    public BankEmployee() { // Adding a default Const.
    }
    public void createBankCustomer(String username, String password) {
    }
    public BankEmployee(String username, String password) {
        super(username, password);

    }

    public void creditRequests(CreditApproval creditApproval){
    for (BankCustomer bankCustomer:creditApproval.getCreditApprovals()){
        System.out.println("This is your credit requests status" +bankCustomer);
        }
    }
}
