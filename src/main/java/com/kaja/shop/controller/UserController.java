package com.kaja.shop.controller;

import com.kaja.shop.domain.User;
import com.kaja.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User searchUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public void handleEntityNotFound(EntityNotFoundException e) {

    }
}
