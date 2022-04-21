package com.ex.BankCustomer;
import com.ex.BankCustomer.BankCustomer;
import com.ex.Repositories.BankCustomerRepository;

import java.util.ArrayList;

public class CreditApproval {
    /**
     * This class implements creditCheck method to determine customers credit approvals based on their credit score
     * Method also implements a credit approval business logic
     */
    private ArrayList<BankCustomer> creditApprovals;
    private double low_int = 0.5;
    private double low_high_int = 1.5;
    private double high_int = 5.0;


    public CreditApproval(ArrayList<BankCustomer> creditApprovals) {
        this.creditApprovals = creditApprovals;
    }

    public ArrayList<BankCustomer> getCreditApprovals() {
        return creditApprovals;
    }

    public void setCreditApprovals(ArrayList<BankCustomer> creditApprovals)
    {
        this.creditApprovals = creditApprovals;
    }

    public CreditApproval()
    {
        this.creditApprovals=new ArrayList<BankCustomer>();
    }
    // Implementing a method of send credit approval requests
    public void sendRequests(BankCustomer customer){
    creditApprovals.add(customer);
    }

    /**
     * This method implements the credit check based on the Customer's credit score, and gives the approval. If credit
     * score too low, then it's denied, auto approval if score is high, and send request for approval is score is >=400
     * @param bankCustomer
     */
    public String CreditCheck(BankCustomer bankCustomer){
        if(bankCustomer.getCreditScore()>=750){
            System.out.println("Excellent Credit, Application approved with very minimal rate: " +low_int);
        }else if (bankCustomer.getCreditScore()>=650){
            System.out.println("Good Credit, Approval with low rate of interest: " +low_high_int);
        }else if(bankCustomer.getCreditScore()>=400){
            System.out.println("Poor credit, requires review with rate of interest is: "+high_int);
            sendRequests(bankCustomer); // Sending requests for the approval
        }else if(bankCustomer.getCreditScore()<=250){
            System.out.println("Your Line of credit application is denied");
        }
            return "Something went wrong";}

        /**
         * Now let's implement a method that checks approvals based on credit score for list of all bank customers
         * from customer repository
         */
        public void checkCreditAll(BankCustomerRepository repository) {
            for(BankCustomer user : repository.getAll()) {
                CreditCheck(user);
            }
        }


}
