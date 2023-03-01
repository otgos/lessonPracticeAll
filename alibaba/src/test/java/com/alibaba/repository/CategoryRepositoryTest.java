package com.alibaba.repository;

import com.alibaba.entity.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository repositoryTest;

    @AfterEach
    void tearDown(){
        repositoryTest.deleteAll();
    }

    @Test
    void testIfCategoryNameExists() {

        //given
        Category category = new Category();
        category.setName("TV");
        repositoryTest.save(category);
        //when
        Boolean expected = repositoryTest.existsByName(category.getName());
        //then
        assertThat(expected).isTrue();
    }

    @Test
    void testIfCategoryNameDoesNotExist() {

        //given
        String categoryName = "TV";
        //when
        Boolean expected = repositoryTest.existsByName(categoryName);
        //then
        assertThat(expected).isFalse();
    }
}