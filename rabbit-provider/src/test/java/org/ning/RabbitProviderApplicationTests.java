package org.ning;

import org.junit.jupiter.api.Test;
import org.ning.entity.User;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Project: org.ning
 * @Author: pgthinker
 * @Date: 2024/1/5 21:08
 * @Description:
 */
@SpringBootTest
public class RabbitProviderApplicationTests {
    @Test
    public void test(){

    }
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSendBasicMessage2Queue(){
        String queueName = "basic.queue"; // 消息队列名称
        String message = "Hello RabbitMQ"; // 消息内容
        RabbitAdmin admin = new RabbitAdmin(rabbitTemplate); // 创建RabbitAdmin对象
        Queue queue = new Queue(queueName); // 创建消息队列对象
        admin.declareQueue(queue); // 该方法会在RabbitMQ里创建一个消息队列
        rabbitTemplate.convertAndSend(queueName,message); // 发送消息
    }

    @Test
    public void testSendWorkMessage2Queue() throws InterruptedException {
        String queueName = "work.queue";
        String message = "Hello RabbitMQ ";
        RabbitAdmin admin = new RabbitAdmin(rabbitTemplate);
        Queue queue = new Queue(queueName);
        admin.declareQueue(queue);
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend(queueName, message + i);
            Thread.sleep(20); // 睡眠几毫秒
        }
    }

    @Test
    public void testSendFanoutExchangeMessage2Queue() throws InterruptedException {
        String queueName1 = "fanout.queue1";
        String queueName2 = "fanout.queue2";
        String fanoutExchangeName = "fanout.exchange";

        String message = "Hello RabbitMQ ";
        // 创建RabbitAdmin对象
        RabbitAdmin admin = new RabbitAdmin(rabbitTemplate);

        // 创建一个交换机
        FanoutExchange fanoutExchange = new FanoutExchange(fanoutExchangeName);
        admin.declareExchange(fanoutExchange);
        // 创建队列
        Queue queue1 = new Queue(queueName1);
        Queue queue2 = new Queue(queueName2);
        admin.declareQueue(queue1);
        admin.declareQueue(queue2);
        // 创建绑定关系
        admin.declareBinding(BindingBuilder.bind(queue1).to(fanoutExchange));
        admin.declareBinding(BindingBuilder.bind(queue2).to(fanoutExchange));
        // 向交换机里发送50条消息
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(fanoutExchangeName,"",message + i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testSendDirectExchangeMessage2Queue() throws InterruptedException {
        String queueName1 = "direct.queue1";
        String queueName2 = "direct.queue2";
        String directExchangeName = "direct.exchange";
        String message = "Hello RabbitMQ ";
        Queue queue1 = new Queue(queueName1);
        Queue queue2 = new Queue(queueName2);
        DirectExchange directExchange = new DirectExchange(directExchangeName);
        RabbitAdmin admin = new RabbitAdmin(rabbitTemplate);
        // 创建消息队列
        admin.declareQueue(queue1);
        admin.declareQueue(queue2);
        // 创建Direct交换机
        admin.declareExchange(directExchange);
        // 绑定消息队列与交换机
        admin.declareBinding(
                BindingBuilder.bind(queue1)
                        .to(directExchange)
                        .with("queue" + 1)
        );
        admin.declareBinding(
                BindingBuilder.bind(queue2)
                        .to(directExchange)
                        .with("queue" + 2)
        );
        // 发送消息
        for (int i = 0; i < 100; i++) {
            int routingKey = i % 2 == 0 ? 1 : 2;
            rabbitTemplate.convertAndSend(directExchangeName,"queue" + routingKey, message + i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testSendTopicExchangeMessage2Queue() {

        RabbitAdmin admin = new RabbitAdmin(rabbitTemplate);

        // 创建队列
        String queueName1 = "topic.queue1";
        String queueName2 = "topic.queue2";
        Queue queue1 = new Queue(queueName1);
        Queue queue2 = new Queue(queueName2);
        admin.declareQueue(queue1);
        admin.declareQueue(queue2);
        // 创建TopicExchange
        String topicExchangeName = "topic.exchange";
        TopicExchange topicExchange = new TopicExchange(topicExchangeName);
        admin.declareExchange(topicExchange);
        // 创建绑定关系
        admin.declareBinding(
                BindingBuilder.bind(queue1)
                        .to(topicExchange)
                        .with("rabbit.news")
        );
        admin.declareBinding(
                BindingBuilder.bind(queue2)
                        .to(topicExchange)
                        .with("rabbit.facebook")
        );
        // 生产一些消息
        rabbitTemplate.convertAndSend(topicExchangeName,"rabbit.news","这是news的消息");
        rabbitTemplate.convertAndSend(topicExchangeName,"rabbit.facebook","这是facebook的消息");
    }

    @Test
    public void testSendObject() {
        User user = new User();
        user.setUsername("NingNing0111");
        user.setAge(18);
        rabbitTemplate.convertAndSend("basic.queue",user);
    }
}
