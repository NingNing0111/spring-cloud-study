package org.ning.listener;

import lombok.extern.slf4j.Slf4j;
import org.ning.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

/**
 * @Project: org.ning.listener
 * @Author: pgthinker
 * @Date: 2024/1/6 00:09
 * @Description:
 */
@Component
@Slf4j
public class ObjectMessageListener {
    @RabbitListener(queues = "basic.queue")
    public void listenObject(User user){
        log.info("接收到对象:{}",user);
    }
}
