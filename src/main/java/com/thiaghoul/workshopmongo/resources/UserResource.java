package com.thiaghoul.workshopmongo.resources;

import com.thiaghoul.workshopmongo.domain.Post;
import com.thiaghoul.workshopmongo.domain.User;
import com.thiaghoul.workshopmongo.dto.UserDTO;
import com.thiaghoul.workshopmongo.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController // Marks this class as a REST controller, enabling it to handle HTTP requests
@RequestMapping(value = "/users") // Sets the base URI path for all methods in this controller to "/users"
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping  // Maps this method to the GET request on "/users" path
    public ResponseEntity<List<UserDTO>> findAll(){
        // Retrieves all users using the service layer
        List<User> list = service.findAll();
        // Converts the list of User objects into a list of UserDTOs
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        // Returns the list of UserDTOs with an HTTP status of 200 OK
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")  // Maps this method to the GET request on "/users/{id}" path
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        // Fetches the user by its ID from the service layer
        User user = service.findById(id);
        // Returns the user as a UserDTO with an HTTP status of 200 OK
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @GetMapping(value = "/{id}/posts")  // Maps this method to the GET request on "/users/{id}/posts"
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        // Fetches the user by their ID
        User user = service.findById(id);
        // Returns the list of posts associated with the user
        return ResponseEntity.ok().body(user.getPosts());
    }

    @PostMapping()  // Maps this method to the POST request on "/users" path
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        // Converts the UserDTO into a User entity
        User user = service.fromDTO(userDTO);
        // Inserts the new user into the database
        user = service.insert(user);
        // Creates a URI for the newly created user
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        // Returns a ResponseEntity with the URI of the new user and HTTP status 201 Created
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")  // Maps this method to the DELETE request on "/users/{id}"
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        // Deletes the user by its ID using the service layer
        service.delete(id);
        // Returns HTTP status 204 No Content, indicating successful deletion
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")  // Maps this method to the PUT request on "/users/{id}" path
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO userDTO){
        // Converts the UserDTO to a User entity
        User user = service.fromDTO(userDTO);
        // Sets the ID of the user to match the provided path variable
        user.setId(id);
        // Updates the user in the database using the service layer
        user = service.update(user);
        // Returns HTTP status 204 No Content, indicating the update was successful
        return ResponseEntity.noContent().build();
    }



}
