package com.kaja.shop.mapper;

import com.kaja.shop.domain.dao.User;
import com.kaja.shop.domain.dto.UserDto;

public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
}
