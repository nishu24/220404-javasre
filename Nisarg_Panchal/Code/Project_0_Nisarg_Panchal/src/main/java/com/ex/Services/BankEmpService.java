package com.ex.Services;

import com.ex.BankCustomer.BankCustomer;
import com.ex.BankCustomer.CustomerAccount;
import com.ex.BankEmployee.BankEmployee;
import com.ex.Exceptions.UserNotFoundException;
import com.ex.Exceptions.ListEmptyException;
import com.ex.Repositories.BankEmployeeRepository;


public class BankEmpService {
    public BankEmpService(BankEmployeeRepository bankEmployeeRepository) {
    }
    public BankEmpService() {
    }

    /** This service class is responsible for creating a new account for bank customers - CreateNewAccount methods
     *  does that.
     * @param bankCustomer
     * @param name
     * @param balance
     */
    public void CreateNewAccount(BankCustomer bankCustomer, String name, float balance){
        bankCustomer.getAccounts().add(new CustomerAccount(balance,name));
    }

    public BankEmployee EmpLogin(String username, String password, BankEmployeeRepository bankEmpRepos) throws IllegalStateException, UserNotFoundException, ListEmptyException {
        if (username==null && password==null){
            throw new IllegalStateException("They cannot be null");
        } else {
            if (bankEmpRepos.getAll().isEmpty())
            {
                throw new ListEmptyException("User list cannot be empty");
            } else
            {
                for (BankEmployee user: bankEmpRepos.getAll())
                {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password))
                    {
                        return user;
                    }
                } throw new UserNotFoundException("User cannot be found");
            }
        }
    }
}
