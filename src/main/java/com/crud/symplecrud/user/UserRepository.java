package com.crud.symplecrud.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository   <User, Integer> {
//press control ann CrudRepository to how is aviable  actually
    public Long countById(Integer id);
}
