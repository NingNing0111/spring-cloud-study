package org.ning.controller;

import lombok.RequiredArgsConstructor;
import org.ning.entity.User;
import org.ning.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project: org.ning.controller
 * @Author: pgthinker
 * @Date: 2024/1/4 22:43
 * @Description:
 */
@RequestMapping("consumer")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("all")
    public List<User> userAll(){
        return userService.queryAll();
    }
}
