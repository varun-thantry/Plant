package com.tc.PlantNursery.service;

import com.tc.PlantNursery.entity.Product;
import com.tc.PlantNursery.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long pid){
        return productRepo.findById(pid);
    }

}
