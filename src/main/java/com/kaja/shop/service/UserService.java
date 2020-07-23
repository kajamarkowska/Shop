package com.kaja.shop.service;

import com.kaja.shop.domain.dao.User;

public interface UserService {

    User save(User user);

    User findUserById(Long id);
}
