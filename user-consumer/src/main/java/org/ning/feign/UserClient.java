package org.ning.feign;

import org.ning.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Project: org.ning.feign
 * @Author: pgthinker
 * @Date: 2024/1/4 22:39
 * @Description:
 */
@FeignClient("UserProvider") // 微服务注册时的昵称
public interface UserClient {
    @GetMapping("/user/all")
    List<User> getAllUser();
}
