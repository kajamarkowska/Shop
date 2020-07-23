package com.kaja.shop.mapper.impl;

import com.kaja.shop.domain.dao.User;
import com.kaja.shop.domain.dto.UserDto;
import com.kaja.shop.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {


    @Override
    public User userDtoToUser(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .id(userDto.getId())
                .password(userDto.getPassword())
                .build();
    }

    @Override
    public UserDto userToUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }
}
