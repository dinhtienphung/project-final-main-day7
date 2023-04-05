package com.mycompany.spring_mvc_project_final.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "name",length = 5000)
    private String name;

    @Column (name = "price")
    private double price;
    @Lob
    @Column (name = "image")
    private byte [] image;

    @Lob
    @Column (name = "image1")
    private byte [] image1;

    @Lob
    @Column (name = "image2")
    private byte [] image2;

    @Lob
    @Column (name = "image3")
    private byte [] image3;

    @Lob
    @Column (name = "banner")
    private byte [] banner;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date productDate;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "description",length = 5000)
    private String description;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="categoryId")
    private Category category;
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToOne (cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private ProductDetail productDetails;


    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public byte[] getImage2() {
        return image2;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public byte[] getImage3() {
        return image3;
    }

    public void setImage3(byte[] image3) {
        this.image3 = image3;
    }

    public byte[] getBanner() {
        return banner;
    }

    public void setBanner(byte[] banner) {
        this.banner = banner;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public ProductDetail getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetail productDetails) {
        this.productDetails = productDetails;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
