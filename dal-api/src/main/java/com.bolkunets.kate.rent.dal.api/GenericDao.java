package com.bolkunets.kate.rent.dal.api;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T, K extends Serializable> {

    K save(T obj);

    void update(T obj);

    Optional<T> find(K id);

    List<T> find();

    void delete(T obj);

    void saveOrUpdate(T obj);

}
