package com.rodolpho.study.repositories;

import com.rodolpho.study.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
