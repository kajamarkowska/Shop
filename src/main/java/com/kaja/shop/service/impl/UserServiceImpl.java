package com.kaja.shop.service.impl;

import com.kaja.shop.domain.dao.User;
import com.kaja.shop.repository.UserRepository;
import com.kaja.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
