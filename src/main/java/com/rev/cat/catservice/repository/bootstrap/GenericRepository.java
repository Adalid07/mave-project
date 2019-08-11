package com.rev.cat.catservice.repository.bootstrap;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/*
* @autor rveizaga
*/
public interface GenericRepository<T extends GenericDomain> extends MongoRepository<T, String> {

    @Query("{ 'id' : ?0 }")
    T findOne(String id);
}
