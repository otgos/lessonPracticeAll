package com.alibaba.controller;

import com.alibaba.entity.Category;
import com.alibaba.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController //Controller class which will help us to return JASON data
@RequestMapping ("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;



//    @PostMapping("/add")
//    public ResponseEntity<String> addCategory(@RequestBody Category category){
//        Category createdCtegory = categoryService.addCategory(category);
//        if(createdCtegory !=null){
//            return new ResponseEntity<>("Category has been created successfully", HttpStatus.CREATED);
//
//        }else{
//            return new ResponseEntity<>("Category is not created", HttpStatus.BAD_REQUEST);
//        }
//
//    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category createdCtegory = categoryService.addCategory(category);
        return new ResponseEntity<>(createdCtegory, HttpStatus.CREATED);
    }

//method will return all category list
    @GetMapping("/getAllCategories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoryList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

        @GetMapping("/getById/{catId}")
        public ResponseEntity<Category> getCategoryById(@PathVariable("catId") Long categoryId){
            Category category =  categoryService.getCategoryById(categoryId);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        @DeleteMapping("/deletById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ("id") Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category is deleted successfully", HttpStatus.OK);
        }

        @PutMapping("/updateCategory/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category){
        Category updatedCat = categoryService.update(category, id);
            return new ResponseEntity<>(updatedCat, HttpStatus.OK);

        }

}
