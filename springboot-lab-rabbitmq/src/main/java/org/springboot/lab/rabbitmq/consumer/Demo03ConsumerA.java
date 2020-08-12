package org.springboot.lab.rabbitmq.consumer;

import org.springboot.lab.rabbitmq.message.Demo03Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@RabbitListener(queues = Demo03Message.QUEUE_A)
@Slf4j
public class Demo03ConsumerA {

    @RabbitHandler
    public void onMessage(Demo03Message message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
