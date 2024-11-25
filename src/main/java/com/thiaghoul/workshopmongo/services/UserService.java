package com.thiaghoul.workshopmongo.services;

import com.thiaghoul.workshopmongo.domain.User;
import com.thiaghoul.workshopmongo.dto.UserDTO;
import com.thiaghoul.workshopmongo.repositories.UserRepository;
import com.thiaghoul.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("id not found!"));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user){
        Optional<User> optionalUser = repository.findById(user.getId());
        User newUser = optionalUser.get();
        updateData(newUser, user);
        return repository.save(newUser);

    }

    public void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
