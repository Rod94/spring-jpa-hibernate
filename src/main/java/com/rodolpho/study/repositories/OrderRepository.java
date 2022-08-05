package com.rodolpho.study.repositories;

import com.rodolpho.study.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
