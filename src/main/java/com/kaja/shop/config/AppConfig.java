package com.kaja.shop.config;

import com.kaja.shop.domain.dao.Role;
import com.kaja.shop.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class AppConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
        return args -> {
            createRoleIfEmpty(roleRepository, "ROLE_USER");
            createRoleIfEmpty(roleRepository, "ROLE_ADMIN");
        };

    }

    private void createRoleIfEmpty(RoleRepository roleRepository, String name) {
        Optional<Role> role = roleRepository.findByName(name);
        if (role.isEmpty()) {
            roleRepository.save(Role.builder().name(name).build());
        }
    }
}
