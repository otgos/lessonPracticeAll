package com.alibaba.service;

import com.alibaba.entity.Brand;
import com.alibaba.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand addBrand(Brand brand){
        return brandRepository.save(brand);
    }

    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

    public Brand getById(Long id){
        Brand foundBrand = getBrand(id);
        return foundBrand;
    }

    public Brand getBrand(Long id) {
        return brandRepository.findById(id).orElseThrow();
    }

    public void deleteBrand(Long id){
        Brand foundBrand = getBrand(id);
        brandRepository.delete(foundBrand);
    }
    public Brand updateBrand(Brand brand, Long id){
        Brand foundBrand = getBrand(id);
        foundBrand.setName(brand.getName());
        return brandRepository.save(foundBrand);
    }
}
