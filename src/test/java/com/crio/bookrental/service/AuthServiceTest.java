package com.crio.bookrental.service;
/*
 * @author adityagupta
 * @date 05/04/24
 */


import com.crio.bookrental.dto.AuthRequestDTO;
import com.crio.bookrental.dto.RegisterRequestDTO;
import com.crio.bookrental.dto.ResponseDTO;
import com.crio.bookrental.entity.Role;
import com.crio.bookrental.entity.User;
import com.crio.bookrental.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegister_Success() {
        // Mock data
        RegisterRequestDTO request = new RegisterRequestDTO();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmail("john.doe@example.com");
        request.setPassword("password");
        request.setRole(Role.USER);

        // Mock repository behavior
        when(userRepository.save(any())).thenReturn(new User());
        when(passwordEncoder.encode(request.getPassword())).thenReturn("hashedPassword");

        // Call the service method
        ResponseDTO responseDTO = authService.register(request);

        // Assertions
        assertNotNull(responseDTO);
        assertEquals("User registered successfully.", responseDTO.getMessage());
    }

    @Test
    public void testLogin_Success() {
        // Mock data
        AuthRequestDTO request = new AuthRequestDTO();
        request.setEmail("john.doe@example.com");
        request.setPassword("password");

        // Call the service method
        ResponseDTO responseDTO = authService.login(request);

        // Assertions
        assertNotNull(responseDTO);
        assertEquals("User logged in Successfully", responseDTO.getMessage());
    }

}

