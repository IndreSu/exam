package com.example.exam.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("api/v1/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {

        this.usersService = usersService;
    }

    @GetMapping("/{userId}")
    public Optional<Users> getUsers(@PathVariable Long usersId) {

        return usersService.getById(usersId);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Users> getAllUsers() {

        return usersService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UsersDto> addUsers(@RequestBody UsersDto usersDto) {
        UsersDto createdUsers = usersService.addUsers(usersDto);
        return new ResponseEntity<>(createdUsers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable("id") Long id) {
        usersService.deleteUsers(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

