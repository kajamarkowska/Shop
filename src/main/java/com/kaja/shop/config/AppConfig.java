package com.kaja.shop.config;

import com.kaja.shop.domain.dao.Role;
import com.kaja.shop.repository.RoleRepository;
import com.kaja.shop.service.impl.WatcherServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.Optional;

@Configuration
public class AppConfig {


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository, WatcherServiceImpl watcherServiceImpl) {
        return args -> {
            createRoleIfEmpty(roleRepository, "ROLE_USER");
            createRoleIfEmpty(roleRepository, "ROLE_ADMIN");
            new Thread(watcherServiceImpl, "Thread").start();
        };

    }

    @Bean
    Docket docket() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("Authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("")
                .globalOperationParameters(Collections.singletonList(parameterBuilder.build()));
    }

    private void createRoleIfEmpty(RoleRepository roleRepository, String name) {
        Optional<Role> role = roleRepository.findByName(name);
        if (role.isEmpty()) {
            roleRepository.save(Role.builder().name(name).build());
        }
    }
}
