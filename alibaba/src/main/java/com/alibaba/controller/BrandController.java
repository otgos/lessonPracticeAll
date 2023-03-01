package com.alibaba.controller;

import com.alibaba.entity.Brand;
import com.alibaba.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

   //http://localhost:8082/brand/add
    @PostMapping("/add")
    public ResponseEntity<Brand> addBrand(@RequestBody Brand brand){
       Brand newBrand =  brandService.addBrand(brand);
       return new ResponseEntity<>(newBrand, HttpStatus.CREATED);
    }

    @GetMapping("/getAllBrands")
    public ResponseEntity<List<Brand>> getAllBrands(){
        List<Brand> allBrands =  brandService.getAllBrands();
        return new ResponseEntity<>(allBrands, HttpStatus.OK);
    }

    @GetMapping ("/getById/{brandId}")
    public ResponseEntity<Brand> getById(@PathVariable("brandId") Long id){
        Brand brand = brandService.getById(id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }
    @DeleteMapping("/deleteBrand/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        brandService.deleteBrand(id);
        return new ResponseEntity<>("Brand is deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/updateBrand/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable("id") Long id, @RequestBody Brand brand){
        Brand updatedBrand = brandService.updateBrand(brand, id);
        return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
    }

}
