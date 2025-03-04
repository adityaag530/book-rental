package com.crio.bookrental.service;

import com.crio.bookrental.dto.AuthRequestDTO;
import com.crio.bookrental.dto.RegisterRequestDTO;
import com.crio.bookrental.dto.ResponseDTO;
import com.crio.bookrental.entity.Role;
import com.crio.bookrental.entity.User;
import com.crio.bookrental.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * @author adityagupta
 * @date 05/04/24
 */
@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public ResponseDTO register(RegisterRequestDTO request) {
        if (request.getRole() == null) {
            request.setRole(Role.USER);
        }
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);
        logger.info("Saving user: {}", user.getEmail());
        return ResponseDTO.builder().message("User registered successfully.").build();
    }

    public ResponseDTO login(AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()));
        logger.info("User logged in: {}", request.getEmail());
        return ResponseDTO.builder().message("User logged in Successfully").build();
    }


}
