package me.guopop.springbootmybatisdemo.controller;

import me.guopop.springbootmybatisdemo.entity.Product;
import me.guopop.springbootmybatisdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guopop
 * @date 2021/3/20 11:35
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public String queryProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        return "Product: " + product.getName() + "----" + "Price: " + product.getPrice();
    }
}
