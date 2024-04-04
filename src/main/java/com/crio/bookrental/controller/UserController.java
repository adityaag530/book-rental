package com.crio.bookrental.controller;

import com.crio.bookrental.repository.UserRepository;
import com.crio.bookrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @author adityagupta
 * @date 05/04/24
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.removeUser(userId));
    }
}
