package com.kaja.shop.service;

import com.kaja.shop.domain.User;

public interface UserService {

     User save (User user);

     User findUserById(Long id);
}
