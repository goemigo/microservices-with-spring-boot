package com.emily.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

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

import jakarta.validation.Valid;

@RestController // this is the rest api file
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // api for get all users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // api for get one user
    @GetMapping("/users/{userid}")
    public EntityModel<User> retrieveUser(@PathVariable int userid) {
        User user = service.findUser(userid);
        if(user==null){
            throw new UserNotFoundException("id: " +userid);
        }
        //EntityModel and WebMvcLinkBuilder are to implement link in the response
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping("/users/{userid}")
    public void deleteUserById(@PathVariable int userid) {
        service.deleteUserById(userid);
    }

    // api to add a new user, using talend api tester extension to test post on
    // browser
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User saveduser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveduser.getId())
                .toUri();
        // return the status code for this post request and the URI of the newly created
        // resource
        return ResponseEntity.created(location).build();
    }

}
