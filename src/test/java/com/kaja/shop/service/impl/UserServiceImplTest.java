package com.kaja.shop.service.impl;

import com.kaja.shop.domain.dao.User;
import com.kaja.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void shouldFindUserById() {
        User user = User.builder()
                .email("kaja@qp.pl")
                .id(3L)
                .build();
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.of(user));

        User result = userService.findUserById(3L);

        assertThat(user).isEqualTo(result);

    }

    @Test
    void shouldNotFindUserById() {
        Mockito.when(userRepository.findById(4L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.findUserById(4L)).isInstanceOf(EntityNotFoundException.class);
    }


    @Test
    void shouldGetCurrentUser() {
        User user = User.builder()
                .email("test")
                .build();
        Mockito.when(userRepository.findByEmail("test")).thenReturn(Optional.of(user));
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getName()).thenReturn("test");
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        User result = userService.getCurrentUser();

        assertThat(result).isNotNull();
    }

    @Test
    void shouldNotGetCurrentUser() {
        Mockito.when(userRepository.findByEmail("test")).thenReturn(Optional.empty());
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authentication.getName()).thenReturn("test");
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        assertThatThrownBy(() -> userService.getCurrentUser()).isInstanceOf(EntityNotFoundException.class);


    }
}