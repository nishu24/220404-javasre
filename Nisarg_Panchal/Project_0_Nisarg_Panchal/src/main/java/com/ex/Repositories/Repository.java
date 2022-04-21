package com.ex.Repositories;

import com.ex.BankCustomer.BankCustomer;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <ID>
 * @param <E>
 */
public interface Repository<ID,E> {
    List<E> getAll();
    Optional<E> getById(ID id);
    ID save(E obj);
    void update(E obj);
    void delete(E obj);

}
