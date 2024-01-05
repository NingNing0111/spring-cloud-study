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
 * @Date: 2024/1/5 23:07
 * @Description:
 */
@Component
@Slf4j
public class DirectExchangeListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"), // 绑定队列
            exchange = @Exchange(name = "direct.exchange", type = ExchangeTypes.DIRECT), // 绑定交换机
            key = {"queue1","queue2"} // 绑定RoutingKey值
    ))// 当RoutingKey 为queue1和queue2时，会接收来自direct.exchange的交换机的direct.queue1队列的消息
    public void listenDirectQueue12(String message){
        log.info("direct.queue1接收到消息===>{}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "direct.exchange", type = ExchangeTypes.DIRECT),
            key = {"queue2"}
    ))
    public void listenDirectQueue1(String message){
        log.info("direct.queue2接收到消息===>{}",message);
    }

}
