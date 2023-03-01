package com.alibaba.repository;

import com.alibaba.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //we need to specify each class with correct annotations.
//since repository interface is extending from JpaRepository, Spring boot can identify if there is no @Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Boolean existsByName(String name);
    //select * from Category = findAll()
    // Select * FROM tbl_category Where id = 1 = > findById(1)

}
