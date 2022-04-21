package com.ex.Repositories;
import com.ex.BankEmployee.BankEmployee;
import com.ex.IdGenreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankEmployeeRepository implements Repository<Integer, BankEmployee> {

    private List<BankEmployee> users=new ArrayList<>();
    private IdGenreator IDGen;

    public BankEmployeeRepository(IdGenreator IDGen) {
        this.IDGen = IDGen;
    }

    @Override
    public List<BankEmployee> getAll() {
        return users;
    }
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<BankEmployee> getById(Integer id) {
        return users.stream().filter(g->g.getId()==id).findFirst();
    }
    /**
     *
     * @param obj
     * @return
     */
    @Override
    public Integer save(BankEmployee obj) {
        int id = IDGen.nextID();
        obj.setId(id);
        users.add(obj);
                return id;
    }

    @Override
    public void delete(BankEmployee obj) {

    }

    @Override
    public void update(BankEmployee obj) {

    }

    public void init() {
//        this.users.add(new BankEmployee("employee1", "Password1"));
        this.save(new BankEmployee("employee1", "Password1"));
//        this.save(new BankEmployee("employee2", "Password2"));
    }
}
