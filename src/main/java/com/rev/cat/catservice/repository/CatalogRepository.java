package com.rev.cat.catservice.repository;

import com.rev.cat.catservice.domain.Catalog;
import com.rev.cat.catservice.repository.bootstrap.GenericRepository;

public interface CatalogRepository extends GenericRepository<Catalog> {

    Catalog findByName(String name);
}
