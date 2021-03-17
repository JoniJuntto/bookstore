package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

import org.junit.jupiter.api.Test;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class userRepositoryTest {

    @Autowired
    private UserRepository repository;
    
    @Test
    public void findByUsernameShouldReturnUser() {
    List<User> users = (List<User>) repository.findAll();
    assertThat(users.get(0).getUsername()).isEqualTo("user");
    }
    
    
    
    @Test
    public void createNewStudent() {
    	User user = new User("Mikko", "Mikonsalasana123", "Testaaja");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }    

}