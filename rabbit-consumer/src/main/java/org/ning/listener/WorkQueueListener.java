package org.ning.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Project: org.ning.listener
 * @Author: pgthinker
 * @Date: 2024/1/5 21:55
 * @Description:
 */
@Component
@Slf4j
public class WorkQueueListener {
    @RabbitListener(queues = "work.queue")
    public void consumer1(String message) throws InterruptedException {
        log.info("consumer-1:{}",message);
        Thread.sleep(20); // 设置不同的消费者消费能力
    }
    @RabbitListener(queues = "work.queue")
    public void consumer2(String message) throws InterruptedException {
        log.info("consumer-2:{}",message);
        Thread.sleep(2000);
    }
}
