package com.crud.symplecrud.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void save(User user){
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result=repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Couldnt find the user");
    }

    public void deletUser(Integer id) throws UserNotFoundException {
        Long count=repo.countById(id);
        if(count==null || count ==0){
            throw new UserNotFoundException("Couldnt find the user");
        }
        repo.deleteById(id);
    }
}
