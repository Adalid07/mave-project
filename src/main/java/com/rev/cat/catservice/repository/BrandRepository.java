package com.rev.cat.catservice.repository;

import com.rev.cat.catservice.domain.Brand;
import com.rev.cat.catservice.repository.bootstrap.GenericRepository;

/*
* @autor rveizaga
*/
public interface BrandRepository extends GenericRepository<Brand> {

    Brand findByName(String name);
}
