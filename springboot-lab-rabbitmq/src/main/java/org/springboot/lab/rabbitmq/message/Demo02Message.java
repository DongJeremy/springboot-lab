package org.springboot.lab.rabbitmq.message;

import java.io.Serializable;

public class Demo02Message implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String QUEUE = "QUEUE_DEMO_02";

    public static final String EXCHANGE = "EXCHANGE_DEMO_02";

    public static final String ROUTING_KEY = "#.yu.nai";

    /**
     * 编号
     */
    private Integer id;

    public Demo02Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo02Message{" + "id=" + id + '}';
    }

}
