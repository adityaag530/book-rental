package com.crio.bookrental.service;
/*
 * @author adityagupta
 * @date 04/04/24
 */

import com.crio.bookrental.entity.User;
import com.crio.bookrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow( ()-> new UsernameNotFoundException("User NOT found"));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public String removeUser(Integer userId){
        userRepository.deleteById(userId);
        return "User removed successfully.";
    }

}
