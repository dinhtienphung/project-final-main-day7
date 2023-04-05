package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/")
public class ManagerController {
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/manager", method = GET)
    public String showListManager(Model model){
        Object listManager = productService.findAll();
        model.addAttribute("managerList", listManager);
        return "manager";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("searchInput") String searchInput, Model model) {
        List<Product> searchList;
        if (searchInput.isEmpty()) {
            return "redirect:/manager";
        } else {
            searchList = productService.findByNameContaining(searchInput);
        }
        model.addAttribute("managerList",searchList);
        return "manager";
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/manager";

    }

}