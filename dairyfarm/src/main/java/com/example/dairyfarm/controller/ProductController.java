package com.example.dairyfarm.controller;

import com.example.dairyfarm.entity.Product;
import com.example.dairyfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/new")
    public String showProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showProductFormForUpdate(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
