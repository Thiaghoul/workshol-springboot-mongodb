package com.thiaghoul.workshopmongo.services;

import com.thiaghoul.workshopmongo.domain.User;
import com.thiaghoul.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository respository;

    public List<User> findAll(){
        return respository.findAll();
    }
}
