package org.ning.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Project: org.ning.listener
 * @Author: pgthinker
 * @Date: 2024/1/5 22:32
 * @Description:
 */
@Component
@Slf4j
public class FanoutExchangeListener {
    @RabbitListener(queues = "fanout.queue1")
    public void listenExchangeQueue1(String message){
        log.info("queue1的消息==>{}",message);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenExchangeQueue2(String message){
        log.info("queue2的消息==>{}",message);
    }
}
