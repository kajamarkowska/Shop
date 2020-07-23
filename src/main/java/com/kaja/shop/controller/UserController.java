package com.kaja.shop.controller;

import com.kaja.shop.domain.dto.UserDto;
import com.kaja.shop.mapper.UserMapper;
import com.kaja.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


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
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userMapper.userToUserDto(userService.save(userMapper.userDtoToUser(userDto)));
    }

}
