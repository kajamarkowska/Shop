package com.kaja.shop.repository;

import com.kaja.shop.domain.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
}
