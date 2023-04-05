package com.mycompany.spring_mvc_project_final.service;


import com.mycompany.spring_mvc_project_final.entities.Cart;
import com.mycompany.spring_mvc_project_final.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    public Object findAll(){
        return cartRepository.findAll();
    }

    public void deleteAllById(int id) {
        cartRepository.deleteAllById(id);
    }

//
//    public double getAmount () {
//        List<Ca> cartList = cartRepository.getAllCart();
//        double amount = 0;
//        for (Cart cart: cartList) {
//            amount += (cart.getProduct().getPrice()*cart.getQuantity());
//        }
//        return amount;
//    }
//

    public Cart findById(int id) {
        return cartRepository.findById(id);
    }

    public Cart save(Cart cart) {
       return cartRepository.save(cart);
    }

    public Cart findByAccountID(int id) {
        return cartRepository.findByAccountID(id);
    }
}

