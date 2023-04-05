package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query(value = " select * from orders where id = ?1", nativeQuery = true)
    Order getByIdOrder(int  id);
    @Query(value="SELECT * FROM orders WHERE accountId = ?1", nativeQuery = true)
    List<Order> findByAccountId(int id);

    Order findById(int id);


}
