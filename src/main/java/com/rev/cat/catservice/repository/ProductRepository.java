package com.rev.cat.catservice.repository;

import com.rev.cat.catservice.domain.Product;
import com.rev.cat.catservice.repository.bootstrap.GenericRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends GenericRepository<Product> {

    List<Product> findByNameOrderByPriceDesc(String name);

    List<Product> findByCatalog_Id(String id);
}
