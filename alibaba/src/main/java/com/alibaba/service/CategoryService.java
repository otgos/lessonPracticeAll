package com.alibaba.service;

import com.alibaba.entity.Category;
import com.alibaba.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //@Service is used to mark the class to be a service provider class.
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    //method to add category object to out data base
    public Category addCategory(Category category){
        if(categoryRepository.existsByName(category.getName())){
            throw new IllegalArgumentException();
        }
        return categoryRepository.save(category);
    }

    //method to bring Category List
    public List<Category> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    //method to bring Category by its id
    public Category getCategoryById(Long id){
       Category category = categoryRepository.findById(id).orElseThrow();
       return category;
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
//        Category foundCategory = categoryRepository.findById(categoryId).orElseThrow();
//        categoryRepository.delete(foundCategory);
    }

    public Category update(Category category, Long id){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(); //find Category from DB
        existingCategory.setName(category.getName());   //using Category object which is coming from user, update field
        return categoryRepository.save(existingCategory); //after setting name, save data to DB
    }

}
