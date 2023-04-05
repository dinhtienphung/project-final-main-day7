package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Category;
import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.entities.ProductDetail;
import com.mycompany.spring_mvc_project_final.service.CategoryService;
import com.mycompany.spring_mvc_project_final.service.ProductDetailService;
import com.mycompany.spring_mvc_project_final.service.ProductService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/")
public class AddProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/add", method = GET)
    public String showNewProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("msg", "Thêm sản phẩm");
        model.addAttribute("action", "addProduct");
        model.addAttribute("type", "Add New Book");
        model.addAttribute("change", "Đồng Ý Thêm");

        setCategoryDropDownList(model);

        return "editproduct";
    }



    @RequestMapping(value = "/addProduct", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, "application/x-www-form-urlencoded;charset-UTF-8"} )
    public ModelAndView save(Product product, @RequestParam("name") String name,
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
            product.setName(name);
            product.setImage(photo.getBytes());
            product.setImage1(photo1.getBytes());
            product.setImage2(photo2.getBytes());
            product.setImage3(photo3.getBytes());
            product.setBanner(photo4.getBytes());
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setProductDate(new Date());
            productService.save(product);

            ProductDetail productDetail = new ProductDetail();
            productDetail.setInformation(information);
            productDetail.setProduct_batteries(product_batteries);
            productDetail.setProduct_chip(product_chip);
            productDetail.setProduct_frontCamera(product_frontCamera);
            productDetail.setProduct_ram(product_ram);
            productDetail.setProduct_rearCamera(product_rearCamera);
            productDetail.setProduct_screen(product_screen);
            productDetail.setProduct_system(product_system);
            productDetail.setProduct(product);
            productDetailService.save(productDetail);

            return new ModelAndView( "redirect:/manager");
            //return new ModelAndView("stu", "msg", "Records succesfully inserted into database.");

        } catch (Exception e) {
            return new ModelAndView("redirect:/add", "msg", "Error: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/getProductPhoto/{id}")
    public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
        response.setContentType("image/jpeg");

        Product p = productService.findById(id);
        byte[] ph = p.getImage();
        InputStream inputStream = new ByteArrayInputStream(ph);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    public void setCategoryDropDownList(Model model) {
        List<Category> cateList = (List<Category>)categoryService.findAll();
        if (!cateList.isEmpty()) {
            Map<Integer, String> cateMap = new LinkedHashMap<>();
            for (Category category: cateList) {
                cateMap.put(category.getId(), category.getName());
            }
            model.addAttribute("categoryList", cateMap);
        }
    }
}
