package org.ning.controller;

import lombok.RequiredArgsConstructor;
import org.ning.entity.User;
import org.ning.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project: org.ning.controller
 * @Author: pgthinker
 * @Date: 2024/1/4 22:25
 * @Description:
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @GetMapping("all")
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
