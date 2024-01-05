package org.ning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Project: org.ning
 * @Author: pgthinker
 * @Date: 2024/1/5 21:10
 * @Description:
 */
@SpringBootApplication
public class RabbitConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class,args);
    }
}
