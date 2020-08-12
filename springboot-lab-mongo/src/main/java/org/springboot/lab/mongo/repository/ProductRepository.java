package org.springboot.lab.mongo.repository;

import org.springboot.lab.mongo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {
}
