package org.springboot.lab.rabbitmq.consumer;

import org.springboot.lab.rabbitmq.message.Demo02Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@RabbitListener(queues = Demo02Message.QUEUE)
@Slf4j
public class Demo02Consumer {

    @RabbitHandler
    public void onMessage(Demo02Message message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
