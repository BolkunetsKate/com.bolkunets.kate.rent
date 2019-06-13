package com.bolkunets.kate.rent.jpahiber.dal;

import com.bolkunets.kate.rent.dal.api.GenericDao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class AbstractDao<T, K extends Serializable> implements GenericDao<T, K> {
    @Override
    public K save(final T t) {
        return null;
    }

    @Override
    public void update(final T t) {

    }

    @Override
    public Optional<T> find(final K k) {
        return Optional.empty();
    }

    @Override
    public List<T> find() {
        return null;
    }

    @Override
    public void delete(final T t) {

    }

    @Override
    public void saveOrUpdate(final T t) {

    }
}
