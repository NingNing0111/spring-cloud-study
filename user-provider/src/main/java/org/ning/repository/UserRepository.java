package org.ning.repository;

import org.ning.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * @Project: org.ning.repository
 * @Author: pgthinker
 * @Date: 2024/1/4 22:19
 * @Description:
 */
@Repository
public class UserRepository {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public List<User> findAll(){
        return generateUserList(10);
    }

    // 随机生成10用户数据
    private List<User> generateUserList(int number){
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            User user = new User();
            user.setId(random.nextInt(10,1000));
            user.setName(generateRandomString(5));
            user.setPassword(generateRandomString(64));
            users.add(user);
        }
        return users;
    }

    private String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
