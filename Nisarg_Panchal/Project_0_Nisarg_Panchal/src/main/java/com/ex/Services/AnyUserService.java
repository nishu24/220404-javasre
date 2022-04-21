package com.ex.Services;
import com.ex.GeneralUser.AnyUser;
import com.ex.Exceptions.ListEmptyException;
import com.ex.Repositories.AnyUserRepository;
import com.ex.BankCustomer.BankCustomer;
import com.ex.Repositories.BankCustomerRepository;
import com.ex.Exceptions.UserNotFoundException;

public class AnyUserService extends AnyUser {
    /**
     *
     * @param username
     * @param password
     * @param AnyUserRepos
     * @return
     * @throws UserNotFoundException
     * @throws IllegalStateException
     * @throws ListEmptyException
     */
// User login function.
    public AnyUser authenticate(String username, String password, AnyUserRepository AnyUserRepos) throws UserNotFoundException,IllegalStateException, ListEmptyException {
        if(username==null || password==null){
            throw new IllegalStateException("Username or Password cannot be null"); //Checking for Null values
        }else {
            if (AnyUserRepos.getAll().isEmpty()){
                throw new ListEmptyException("User list cannot be empty");
            } else{
                for (AnyUser user: AnyUserRepos.getAll()){
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                        return user;
                    }
                } throw new UserNotFoundException("User cannot be found");
            }
        }
    }

    /**
     *
     * @param username
     * @param password
     * @param UR
     * @return
     * @throws UserNotFoundException
     * @throws IllegalStateException
     * @throws ListEmptyException
     */
    // Bank Customer Login Functionality, taking username, password & userRepository list from BankCustomerRepository
        public BankCustomer login(String username, String password, BankCustomerRepository UR) throws UserNotFoundException, IllegalStateException, ListEmptyException{
        if(username==null || password==null){
            throw new IllegalStateException("Username or password cannot be null");
        }else{
            if(UR.getAll().isEmpty()){
                throw new ListEmptyException("User List Empty");
            }else{
                for(BankCustomer cust:UR.getAll()){
                    if(cust.getUsername().equals(username) && cust.getPassword().equals(password)){
                        return cust;
                    }
                } throw new UserNotFoundException("Username & password not correct");
            }
        }
    }
}
