package org.ning.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Project: org.ning.listener
 * @Author: pgthinker
 * @Date: 2024/1/5 23:41
 * @Description:
 */
@Component
@Slf4j
public class TopicExchangeListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "topic.exchange", type = ExchangeTypes.TOPIC),
            key = {"topic.#"} // 发送到facebook的消息也会接收
    ))
    public void listenTopicAllMessage(String message){
        log.info("所有来自topic.#的消息===>{}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "topic.exchange", type = ExchangeTypes.TOPIC),
            key = {"topic.facebook"}
    ))
    public void listenTopicFacebookMessage(String message){
        log.info("所有来自topic.facebook的消息===>{}",message);
    }
}
