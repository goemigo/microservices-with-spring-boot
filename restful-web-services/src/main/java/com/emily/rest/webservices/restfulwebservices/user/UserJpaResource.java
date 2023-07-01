package com.emily.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emily.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController // this is the rest api file
public class UserJpaResource {

    private UserRepository repository;

    public UserJpaResource(UserRepository repository) {

        this.repository = repository;
    }

    // api for get all users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    // api for get one user
    @GetMapping("/jpa/users/{userid}")
    public EntityModel<User> retrieveUser(@PathVariable int userid) {
        Optional<User> user = repository.findById(userid);
        if (user == null) {
            throw new UserNotFoundException("id: " + userid);
        }
        // EntityModel and WebMvcLinkBuilder are to implement link in the response
        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping("/jpa/users/{userid}")
    public void deleteUserById(@PathVariable int userid) {
        repository.deleteById(userid);
    }

    // api to add a new user, using talend api tester extension to test post on
    // browser
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User saveduser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveduser.getId())
                .toUri();
        // return the status code for this post request and the URI of the newly created
        // resource
        return ResponseEntity.created(location).build();
    }

}