package org.ning.service;

import lombok.RequiredArgsConstructor;
import org.ning.entity.User;
import org.ning.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @Project: org.ning.service
 * @Author: pgthinker
 * @Date: 2024/1/6 19:52
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void add(User user){
        userRepository.save(user);
    }
    public List<User> findAll(){
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
    }
    public void update(User user){
        userRepository.save(user);

    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
