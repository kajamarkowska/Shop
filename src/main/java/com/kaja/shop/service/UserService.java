package com.kaja.shop.service;

import com.kaja.shop.domain.dao.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

    User save(User user);

    User findUserById(Long id);

    Page<User> page(Pageable pageable);

    User getCurrentUser();

    void deleteUserById(Long id);

    User updateUser(User user,Long id);
}
