import com.ex.*;
import com.ex.BankCustomer.BankCustomer;
import com.ex.Exceptions.InvalidWithdrawalException;
import com.ex.Services.BankCustomerService;
import com.ex.Exceptions.NotValidWithdrawAmountException;
import com.ex.Repositories.BankCustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.InvalidTransactionException;

public class CustomerTests {
    /**
     *
     */
    private BankCustomerService bcs; //Setting up the object of BankCustomer service class
    private BankCustomerRepository bcr;  // Setting up the object of Bank customer's repository class
    private BankCustomer bc;

    private IdGenreator IdGen; // Creating an object of the IdGenerator class.

    @BeforeEach
    public void runsBeforeEveryTest(){
//        IdGen = new IdGenreator(0);
//        testRepos = new BankCustomerRepository(IdGen);
//        testCustomerSer = new BankCustomerService();
//        testRepos.initializeTestList();
        IdGen = new IdGenreator(0);
        bcr = new BankCustomerRepository(IdGen);
        bcs = new BankCustomerService(bcr);
        bcr.initList();
    }
    //We'll see if Bank Customer is able to log in with correct credentials
    @Test
    public void returnCustomerWithCorrectCredentials(){
        String username = "bankUser1", password="Password1";
        bcr.save(new BankCustomer(username,password));
/*
        BankCustomer bc = null;
        try {
            bc = CustomerSer.login(username,password, CustomerRepos);
        } catch (ListEmptyException e) {
            e.printStackTrace();
        }
*/
        BankCustomer bankCustomer = bcs.login(username,password, bcr);
        Assertions.assertNotNull(bankCustomer);
        Assertions.assertEquals(username,bankCustomer.getUsername(),"Username not matching");
        Assertions.assertEquals(password,bankCustomer.getPassword(),"Password not matching");
    }


    @Test
    public void viewBalance(){
        float balance= bcs.seeBalance(bcr.getAll().get(0),0);
        Assertions.assertEquals(balance,1999, "Acct does not match");

        balance= bcs.seeBalance(bcr.getAll().get(1),1);
        Assertions.assertEquals(balance, 1999,"Account does not match");
    }

    @Test
    public void withdrawTest() throws InvalidWithdrawalException, AccountNotFoundException {
        int amt=100; float oldBalance, newBalance;
        oldBalance= bcs.seeBalance(bcr.getAll().get(0),0);
        bcs.withDrawMoney(bcr.getAll().get(0),amt,0 );
        newBalance= bcs.seeBalance(bcr.getAll().get(0),0);
        Assertions.assertEquals(newBalance,oldBalance-amt);

    }

    @Test
    public void AbleToDepositMoney(){
        int addMoney=100;
        float oldBal, newBal;
        oldBal= bcs.seeBalance(bcr.getAll().get(0),0);
        try {
            bcs.deposit(bcr.getAll().get(0),addMoney,0);
        } catch (NotValidWithdrawAmountException e) {
            e.printStackTrace();
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
        }
        newBal= bcs.seeBalance(bcr.getAll().get(0),0);
        Assertions.assertEquals(newBal,oldBal+addMoney,"Money not deposited");

    }



    @Test
    public void TestMoneyWithdrawal(){
        float withdrawAmount = 0;
        float PrevBal, NewBal;

        PrevBal = bcs.seeBalance(bcr.getAll().get(0), 0);
        try {
            bcs.withDrawMoney(bcr.getAll().get(0), withdrawAmount, 0);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
        }
        NewBal = bcs.seeBalance(bcr.getAll().get(0), 0);

        Assertions.assertEquals(NewBal, PrevBal - withdrawAmount);
    }
    @Test
    public void TestMoneyTransfer(){
        int transferAmount = 1000;
        float prevBal, prevBal2, updatedBal, updatedBal2;

        prevBal = bcs.seeBalance(bcr.getAll().get(0), 0);
        prevBal2 = bcs.seeBalance(bcr.getAll().get(0), 1);

        try {
            bcs.transferBalance(bcr.getAll().get(0), 0, 1, transferAmount);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidTransactionException e) {
            e.printStackTrace();
        }

        updatedBal = bcs.seeBalance(bcr.getAll().get(0), 0);
        updatedBal2 = bcs.seeBalance(bcr.getAll().get(0), 1);

        Assertions.assertEquals(updatedBal, prevBal - transferAmount, "Money was not withdrawn from the first account properly");
        Assertions.assertEquals(updatedBal2, prevBal2 + transferAmount, "Money was not added to the second account properly");


    }
}
