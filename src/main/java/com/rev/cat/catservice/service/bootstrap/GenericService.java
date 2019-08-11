package com.rev.cat.catservice.service.bootstrap;

import java.util.List;

public abstract class GenericService<T, S> {
    public abstract List<T> findAll();

    public abstract T findById(String id);

    public abstract T delete(String id);

    public abstract T insert(S dto);

    public abstract T update(String id, S dto);
}
