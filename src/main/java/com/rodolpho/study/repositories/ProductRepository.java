package com.rodolpho.study.repositories;

import com.rodolpho.study.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
