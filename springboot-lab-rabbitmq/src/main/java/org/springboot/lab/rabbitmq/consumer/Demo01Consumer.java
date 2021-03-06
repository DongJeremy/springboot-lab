package org.springboot.lab.rabbitmq.consumer;

import org.springboot.lab.rabbitmq.message.Demo01Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@RabbitListener(queues = Demo01Message.QUEUE)
@Slf4j
public class Demo01Consumer {

    @RabbitHandler
    public void onMessage(Demo01Message message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

//    @RabbitHandler(isDefault = true)
//    public void onMessage(org.springframework.amqp.core.Message message) {
//        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
//    }

}
