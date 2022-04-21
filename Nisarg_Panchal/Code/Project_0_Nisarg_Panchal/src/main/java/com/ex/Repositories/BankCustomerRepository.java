package com.ex.Repositories;

import com.ex.BankCustomer.BankCustomer;
import com.ex.Services.BankEmpService;
import com.ex.IdGenreator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A repository for bank's customer which implements our Base Repository interface, and also implements all its methods,
 * with the @Override annotations
 */
public class BankCustomerRepository implements Repository<Integer,BankCustomer> {
    private IdGenreator IdGen;
    private List<BankCustomer> users = new ArrayList<>();

    public BankCustomerRepository(IdGenreator idGen) {
        IdGen = idGen;
    }

    @Override
    public List<BankCustomer> getAll() {
        return users;
    }

//    @Override
//    public Optional<BankCustomer> getByID(Integer id) {
//        return users.stream()
//                .filter(g->g.getId()==id).findFirst();
//    }

    @Override
    public void update(BankCustomer obj) {

    }

    @Override
    public Optional<BankCustomer> getById(Integer id) {
        return users.stream()
                .filter(g->g.getId()==id).findFirst();
    }


    @Override
    public Integer save(BankCustomer obj) {
        int id = IdGen.nextID();
        obj.setId(id);
        users.add(obj);
        return id;
    }

    @Override
    public void delete(BankCustomer obj) {

    }

    public void initList()
    {
        this.save(new BankCustomer("user1", "pass1"));
        this.save(new BankCustomer("User2", "Pass2"));
//        users.add(new BankCustomer("username1","password1"));
//        this.save(new BankCustomer("username1","password1"));
//        this.save(new BankCustomer("username2","password2"));
        BankEmpService BankEmpSer = new BankEmpService();
        BankEmpSer.CreateNewAccount(this.users.get(0),"checking",1999);
        BankEmpSer.CreateNewAccount(this.users.get(1),"Savings",1999);
        BankEmpSer.CreateNewAccount(this.users.get(2),"checking",1999);
    }

}
