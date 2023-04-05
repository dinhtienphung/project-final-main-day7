package com.mycompany.spring_mvc_project_final.repository;


import com.mycompany.spring_mvc_project_final.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products WHERE categoryId = 1" ,nativeQuery = true)
    List<Product> showList();
    @Query(value = "SELECT * FROM products WHERE categoryId = 1 LIMIT 4" ,nativeQuery = true)
    List<Product> showTopPhone();
    @Query(value = "SELECT * FROM products WHERE categoryId = 2 LIMIT 4 " ,nativeQuery = true)
    List<Product> showTopTaplet();
    @Query(value = "SELECT * FROM products WHERE categoryId = 3 LIMIT 4 " ,nativeQuery = true)
    List<Product> showTopLaptop();
    @Query(value = "SELECT * FROM products WHERE categoryId = 4 LIMIT 4 " ,nativeQuery = true)
    List<Product> showTopDH();
    @Query(value = "SELECT * from products order by id desc LIMIT 1", nativeQuery = true)
    List<Product> showTop1Product();
    @Query(value = "SELECT * from products order by id desc LIMIT 1,4", nativeQuery = true)
    List<Product> showTop4Product();
    @Query(value = "SELECT * from products where name like %?1%", nativeQuery = true)
    List<Product> findByNameContaining(String searchInput);
    @Query(value = "SELECT * from products where categoryId =?1", nativeQuery = true)
    List<Product> getProductByCategoryId(int id);


    @Query(value = "SELECT products.* FROM products where categoryId = ?1 LIMIT 10 OFFSET ?2", nativeQuery = true)
    List<Product> findProductByCategoryId(int id,int pageOut);

}