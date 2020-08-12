package org.springboot.lab.rabbitmq.message;

import java.io.Serializable;

public class Demo03Message implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String QUEUE_A = "QUEUE_DEMO_03_A";

    public static final String QUEUE_B = "QUEUE_DEMO_03_B";

    public static final String EXCHANGE = "EXCHANGE_DEMO_03";

    /**
     * 编号
     */
    private Integer id;

    public Demo03Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo03Message{" + "id=" + id + '}';
    }

}
