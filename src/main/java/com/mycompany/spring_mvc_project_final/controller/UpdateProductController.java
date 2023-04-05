package com.mycompany.spring_mvc_project_final.controller;


import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.service.CategoryService;
import com.mycompany.spring_mvc_project_final.service.ProductDetailService;
import com.mycompany.spring_mvc_project_final.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/")
public class UpdateProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    AddProductController addProductController;

    @Autowired
    ProductDetailService productDetailService;

    @RequestMapping(value = "/update/{id}", method = GET)
    public String showEditProduct(Model model, @PathVariable int id) {
        model.addAttribute("product",  productService.findById(id));
        model.addAttribute("msg", "Chỉnh sửa sản phẩm");
        model.addAttribute("action", "updateProduct");
        model.addAttribute("type", "update");
        model.addAttribute("change", "Thay Đổi");
        addProductController.setCategoryDropDownList(model);
        return "editproduct";
    }

    @RequestMapping(value = "/update/updateProduct", method = POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, "application/x-www-form-urlencoded;charset-UTF-8"} )

    public ModelAndView save (@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestPart("photo") MultipartFile photo,
                              @RequestPart("photo1") MultipartFile photo1,
                              @RequestPart("photo2") MultipartFile photo2,
                              @RequestPart("photo3") MultipartFile photo3,
                              @RequestPart("photo4") MultipartFile photo4,
                              @RequestParam("description") String description,
                              @RequestParam("price") double price,
                              @RequestParam("quantity") int quantity,

                              @RequestParam("information") String information,
                              @RequestParam("product_batteries") String product_batteries,
                              @RequestParam("product_chip") String product_chip,
                              @RequestParam("product_frontCamera") String product_frontCamera,
                              @RequestParam("product_ram") String product_ram,
                              @RequestParam("product_rearCamera") String product_rearCamera,
                              @RequestParam("product_screen") String product_screen,
                              @RequestParam("product_system") String product_system) {
        try {
            Product product1 = productService.findById(id);
            product1.setName(name);

            if(photo.getOriginalFilename() == "") {
                byte[] ph = product1.getImage();
                product1.setImage(ph);
            }else {
                product1.setImage(photo.getBytes());
            }

            product1.setImage1(photo1.getBytes());
            product1.setImage2(photo2.getBytes());
            product1.setImage3(photo3.getBytes());
            product1.setBanner(photo4.getBytes());
            product1.setDescription(description);
            product1.setPrice(price);
            product1.setQuantity(quantity);
            product1.setProductDate(new Date());

            product1.getProductDetails().setInformation(information);
            product1.getProductDetails().setProduct_batteries(product_batteries);
            product1.getProductDetails().setProduct_chip(product_chip);
            product1.getProductDetails().setProduct_frontCamera(product_frontCamera);
            product1.getProductDetails().setProduct_ram(product_ram);
            product1.getProductDetails().setProduct_rearCamera(product_rearCamera);
            product1.getProductDetails().setProduct_screen(product_screen);
            product1.getProductDetails().setProduct_system(product_system);
            product1.getProductDetails().setProduct(product1);

            productService.save(product1);

            return new ModelAndView("redirect:/manager");
            //return new ModelAndView("stu", "msg", "Records succesfully inserted into database.");
        } catch (Exception e) {
            return new ModelAndView("redirect:/add", "msg", "Error: " + e.getMessage());
        }

    }
}
