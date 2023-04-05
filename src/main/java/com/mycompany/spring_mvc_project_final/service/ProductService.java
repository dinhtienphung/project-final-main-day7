package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Object findAll(){
        return productRepository.findAll();
    }
    public List<Product> showList() {
        return productRepository.showList();
    }
    public List<Product> showTopPhone() {
        return productRepository.showTopPhone();
    }
    public List<Product> showTopLaptop() {
        return productRepository.showTopLaptop();
    }
    public List<Product> showTopDH() {
        return productRepository.showTopDH();
    }
    public List<Product> showTopTapLet() {
        return productRepository.showTopTaplet();
    }
    public List<Product> showTop1() {
        return productRepository.showTop1Product();
    }
    public List<Product> showTop4() {
        return productRepository.showTop4Product();
    }

    public Product findById(int id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getProductByCategoryId(int id)
    {
        return productRepository.getProductByCategoryId(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByNameContaining (String searchInput) {
        return productRepository.findByNameContaining(searchInput);
    }


    public List<Product> findProductByCategoryId(int id,int pageOut) {
        return productRepository.findProductByCategoryId(id, pageOut);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

}