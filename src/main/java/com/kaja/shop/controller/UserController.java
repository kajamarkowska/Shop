package com.kaja.shop.controller;

import com.kaja.shop.domain.dto.UserDto;
import com.kaja.shop.mapper.UserMapper;
import com.kaja.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")

public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public UserDto searchUserById(@PathVariable Long id) {
        return userMapper.userToUserDto(userService.findUserById(id));
    }

    @PostMapping
    public UserDto saveUser(@RequestBody @Valid UserDto userDto) {
        return userMapper.userToUserDto(userService.save(userMapper.userDtoToUser(userDto)));
    }

    @GetMapping
    public Page<UserDto> getUserPage(@RequestParam int page, @RequestParam int size) {
        return userService.page(PageRequest.of(page, size)).map(userMapper::userToUserDto);
    }

    @GetMapping("/current")
    public UserDto getCurrentUser(){
        return userMapper.userToUserDto(userService.getCurrentUser());
    }

}
