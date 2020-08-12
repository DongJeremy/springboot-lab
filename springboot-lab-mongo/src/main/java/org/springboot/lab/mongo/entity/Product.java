package org.springboot.lab.mongo.entity;

import org.springboot.lab.mongo.mongo.IncIdEntity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 商品 DO
 */
@Document(collection = "Product")
public class Product extends IncIdEntity<Integer> {

    /**
     * 商品名
     */
    private String name;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

}
