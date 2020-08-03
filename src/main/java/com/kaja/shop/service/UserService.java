package com.kaja.shop.service;

import com.kaja.shop.domain.dao.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    User save(User user);

    User findUserById(Long id);

    Page<User> page(Pageable pageable);
}
