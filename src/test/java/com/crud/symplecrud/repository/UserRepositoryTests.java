package com.crud.symplecrud.repository;

import com.crud.symplecrud.user.User;
import com.crud.symplecrud.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew() {
        User user=new User();
        user.setEmail("sanjudilshan554@gmail.com");
        user.setPassword("Sanjunewsys");
        user.setFirstname("Sanju");
        user.setLastname("kumar");

        User saveUser=repo.save(user);

        Assertions.assertThat(saveUser).isNotNull();
        Assertions.assertThat(saveUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<User> users=repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Integer id=1;
        Optional<User> OPuser=repo.findById(id);
        User user=OPuser.get();
        user.setPassword("Saman");
        repo.save(user);

        User UpdateUser= repo.findById(id).get();
        Assertions.assertThat(UpdateUser.getPassword()).isEqualTo("dcds");

    }

    @Test
    public void testGet(){
        Integer id=1;
        Optional<User> optionalUser=repo.findById(id);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId=2;
        repo.deleteById(userId);

        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
