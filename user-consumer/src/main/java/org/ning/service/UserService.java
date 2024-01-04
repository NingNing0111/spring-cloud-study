package org.ning.service;

import lombok.RequiredArgsConstructor;
import org.ning.entity.User;
import org.ning.feign.UserClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: org.ning.service
 * @Author: pgthinker
 * @Date: 2024/1/4 22:42
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserClient userClient;
    public List<User> queryAll(){
        return userClient.getAllUser();
    }
}
