package com.ex.Repositories;

import com.ex.GeneralUser.AnyUser;
import com.ex.IdGenreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnyUserRepository implements Repository<Integer, AnyUser> {

    private List<AnyUser> users = new ArrayList<>();
    private IdGenreator IDGen;

    public AnyUserRepository(IdGenreator IDGen) {
        this.IDGen = IDGen;
    }

    @Override
    public List<AnyUser> getAll() {
        return users;
    }

    @Override
    public Optional<AnyUser> getById(Integer id) {
        return users.stream()
                .filter(g -> g.getId()== id)
                .findFirst();
    }

    @Override
    public Integer save(AnyUser obj) {
        int id = IDGen.nextID();
        obj.setId(id);
        users.add(obj);
        return id;
    }
    @Override
    public void delete(AnyUser obj) {

    }
    @Override
    public void update(AnyUser obj) {

    }
    /**
     * This init() method initializes the data for the test method to fetch and compare the
     * username and password fields
     */

    public void init() {
        this.users.add(new AnyUser("B@nKu$eR", "P@$$w0rD"));
        this.users.add(new AnyUser("B@nKu$eR2", "P@$$w0rD2"));
        this.users.add(new AnyUser("B@nKu$eR3", "P@$$w0rD3"));
        this.users.add(new AnyUser("B@nKu$eR4", "P@$$w0rD4"));
    }
}
