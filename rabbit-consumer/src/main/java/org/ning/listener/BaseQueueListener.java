package org.ning.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Project: org.ning.listener
 * @Author: pgthinker
 * @Date: 2024/1/5 21:39
 * @Description:
 */
@Component
@Slf4j
public class BaseQueueListener {
    @RabbitListener(queues = "basic.queue")
    public void listenBasicQueueMessage(String message) {
        log.info("=====>接收到消息:{}",message);
    }
}
