package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.ProductDetail;
import com.mycompany.spring_mvc_project_final.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;

    public ProductDetail save(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }
}
