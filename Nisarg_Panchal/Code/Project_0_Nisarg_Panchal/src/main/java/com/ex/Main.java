package com.ex;

import com.ex.BankCustomer.BankCustomer;
import com.ex.DAO.DAO;
import com.ex.Repositories.SQLRepository;
import com.ex.Services.BankCustomerService;
import com.ex.BankCustomer.CustomerAccount;
import com.ex.Services.BankEmpService;
import com.ex.Exceptions.UserNotFoundException;
import com.ex.GeneralUser.AnyUser;
import com.ex.Repositories.BankCustomerRepository;
import com.ex.Utils.DBConnector;
import com.ex.Utils.MySQLConnector;
import io.javalin.Javalin;

import java.net.URI;
import java.util.Optional;

/**
 *
 */
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        DBConnector sqlDB = new MySQLConnector("root", "123456","jdbc:mysql://34.68.5.194:3306/banksystem");
        SQLRepository sqlrepository = new SQLRepository(sqlDB);
	// write your code here

        Javalin app = Javalin.create().start(8080);
    // Creating Javalin app at port 8080 on localhost

        IdGenreator IdGen = new IdGenreator(0);
        // Loading/passing initial value as zero i.e. 0.
        BankCustomerRepository bcRepos = new BankCustomerRepository(IdGen);
        // Passing IdGen to customer's repository
        BankCustomerService bcService = new BankCustomerService(bcRepos);
        // bcService is object of the Customer service class & passing its repository as a value

    // Using app.get to fetch list of all BankCustomer's list in json format
    app.get("/users",context -> {context.contentType("application/json");
    context.json(bcService.getAllUsers());
    });
        /**
         *
         */
    //app.get to fetch user by {id}  --->DONE
        app.get("users/{id}",context -> {
            int id=Integer.parseInt(context.pathParam("id"));
            Optional<BankCustomer> bankCustomer = bcService.getUserById(id);
            if (bankCustomer.isPresent()){context.status(200); //Updating status 200 if bankCustomer is available
                context.contentType("application/json"); // this will display the result in json format
                context.json(bankCustomer.get()); // displaying content from bankCustomer.get
                //else displaying 404 status, and message to try again
            } else{context.status(404); context.result("User Not Found !!, Try again");}
        });

        // Let's try to add the user    ----->DONE

        app.post("/users", context -> {
            context.contentType("application/json");
            BankCustomer bankCustomer=context.bodyAsClass(BankCustomer.class);
            int id=bcService.createUser(bankCustomer);
            context.contentType("application/json");
            context.result("Success");
            context.status(200);
            context.header("Location",String.valueOf(new URI("http://localhost:8080/users/"+id)));
        });

        //Let's try to get user login   --->DONE
        app.get("/login", context -> {
            context.contentType("application/json");
            AnyUser log=context.bodyAsClass(AnyUser.class);
            try{
                BankCustomer bcuser=bcService.login(log.getUsername(),log.getPassword(),bcRepos);
                context.json(bcuser);}catch(UserNotFoundException uex){
                context.result("User not found, \n Please try again,\n Good Luck");
                context.status(404);
            }});

        BankEmpService bankEmpService = new BankEmpService();

        //Let's try to add account for the Bank Customer
        app.post("/users/{id}", context -> {
            context.contentType("application/json");
            CustomerAccount custAct = context.bodyAsClass(CustomerAccount.class);
            int id=Integer.parseInt(context.pathParam("id"));
            if (bcRepos.getById(id).isPresent()){
            bankEmpService.CreateNewAccount(bcRepos.getById(id).get(),custAct.getName(), custAct.getBalance());
            } else{
                context.result("Cannot add account for the user");
                context.status(404);
            }
        });

        //Let's try to implement some method
        app.put("/users/{id}/{actionType}",context -> {
            DAO dao = context.bodyAsClass(DAO.class);
            String actionType = context.pathParam("actionType");

            int id = Integer.parseInt(context.pathParam("id"));
            Optional<BankCustomer> bankCustomer=bcService.getUserById(id);
            if (bankCustomer.isPresent()){
                switch (actionType){
                    case "deposit":
                        bcService.deposit(bankCustomer.get(),dao.getBalance(),dao.getAccountID());
                    break;
                    case "takeout":
                        bcService.withDrawMoney(bankCustomer.get(),dao.getBalance(),dao.getAccountID());
                    break;
                    case "transfer":
                        bcService.transferBalance(bankCustomer.get(),dao.getAccountID(),dao.getReceiverID(),dao.getBalance());
                    break;
                }
            } else{
                context.status(404).result("Action not found");
            }
        });

        //Implement a -credit check requests
        //            -review credit check requests

    }
}
