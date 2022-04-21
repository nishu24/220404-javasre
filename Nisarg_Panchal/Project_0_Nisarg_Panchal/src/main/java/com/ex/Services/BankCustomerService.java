package com.ex.Services;
//As a customer, a user should be able to :-View Balance, Deposit Money, Withdraw, transfer,
// see transaction history, apply for line of credit

import com.ex.BankCustomer.BankCustomer;
import com.ex.BankCustomer.CustomerAccount;
import com.ex.Exceptions.InvalidWithdrawalException;
import com.ex.Exceptions.NotValidWithdrawAmountException;
import com.ex.Repositories.Repository;
import com.ex.Exceptions.UserNotFoundException;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.InvalidTransactionException;
import java.util.List;
import java.util.Optional;

public class BankCustomerService extends AnyUserService {

    private Repository<Integer, BankCustomer> customerRepository;

    public BankCustomerService(Repository<Integer, BankCustomer> customerRepository){
        this.customerRepository = customerRepository;
    }
    public BankCustomerService(){
    }
    public Optional<BankCustomer> getUserById (int id){
        return customerRepository.getById(id);
    }

    public List<BankCustomer> getAllUsers()
    {
        return customerRepository.getAll();
    }
    public int createUser(BankCustomer newBankUser) {
        return customerRepository.save(newBankUser);
    }

    public void updateUser(BankCustomer bankUser) {
        customerRepository.update(bankUser);
    }

    /**This method implements a business logic of withdrawing money from the customer's account
     *
     * @param bc
     * @param withdraw
     * @param accountID
     * @throws InvalidWithdrawalException
     * @throws IllegalStateException
     * @throws AccountNotFoundException
     */
    public void withDrawMoney(BankCustomer bc, float withdraw, int accountID) throws InvalidWithdrawalException, IllegalStateException,AccountNotFoundException
    {
    CustomerAccount ca=bc.getAccounts().get(accountID);
    if(ca!=null){if (withdraw<0){throw new IllegalStateException("");}
    else if(withdraw>ca.getBalance()){throw new InvalidWithdrawalException("");}
    else{ca.setBalance(ca.getBalance()-withdraw);
    bc.getTransactionHistory().add("Withdrawal" +withdraw+"from account"+accountID);}}
    else{throw new AccountNotFoundException("");
    }}

    /**
     *
     * @param bc
     * @param addAmt
     * @param accountID
     * @throws UserNotFoundException
     * @throws IllegalStateException
     * @throws NotValidWithdrawAmountException
     * @throws AccountNotFoundException
     */
    public void deposit(BankCustomer bc, float addAmt, int accountID) throws UserNotFoundException, IllegalStateException, NotValidWithdrawAmountException, AccountNotFoundException
    {
        CustomerAccount ca = bc.getAccounts().get(accountID);
        if(ca!=null)//This makes sure that account exists
        {
            if(addAmt<0) //This makes sure that Cx is not depositing negative amount
            {
                throw new IllegalStateException("Deposit Amount cannot be less than $0");
            } else{
                ca.setBalance(ca.getBalance()+addAmt);
                bc.getTransactionHistory().add("The amount added is"+addAmt+"to your account");
            }
        } else {
            throw new AccountNotFoundException("User account not found:");
        }}

    /**
     *
     * @param bc
     * @param senderId
     * @param recId
     * @param amt
     * @throws IllegalStateException
     * @throws AccountNotFoundException
     * @throws InvalidTransactionException
     */
    public void transferBalance(BankCustomer bc, int senderId, int recId, float amt) throws IllegalStateException,AccountNotFoundException, InvalidTransactionException {
        CustomerAccount caSender = bc.getAccounts().get(senderId);
        CustomerAccount caReceiver = bc.getAccounts().get(recId);
        if (caSender==null||caReceiver==null){
            throw new AccountNotFoundException("Account cannot be found");
        } if (amt<0){
            throw new IllegalStateException("Amount to be transferred cannot be less than zero");
        } if (amt>caSender.getBalance()){
            throw new InvalidTransactionException("Cannot send amount greater than your balance");
        } else{caSender.setBalance(caSender.getBalance()-amt);
            caReceiver.setBalance(caReceiver.getBalance()+amt);
            bc.getTransactionHistory().add("Amount added to your account is "+amt);
        } }

    /**
     * This method is able to display customer's transaction history, fetching data from the getTransactionHistory which
     * is an ArrayList of customers transaction history
     * @param bankCustomer
     */
    public void seeTransacHistory(BankCustomer bankCustomer){
        if (bankCustomer.getTransactionHistory().isEmpty()){
            System.out.println("No History");
        } else{for(String getInfo: bankCustomer.getTransactionHistory()){
            System.out.println("Here is the transaction history"+getInfo);
        }}
    }

    /**
     *
     * @param user
     * @param accountID
     * @return
     * @throws IndexOutOfBoundsException
     */
    public float seeBalance(BankCustomer user, int accountID)throws IndexOutOfBoundsException{
    if (user.getAccounts().size()<=0){
       throw new IndexOutOfBoundsException("Account not found");
    } if (user.getAccounts().size() < accountID+1){
        throw new IndexOutOfBoundsException("Not such account exists");
    }else{
        return user.getAccounts().get(accountID).getBalance();
    }}
}
