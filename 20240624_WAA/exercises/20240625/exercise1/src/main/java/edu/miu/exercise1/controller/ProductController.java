package edu.miu.exercise1.controller;

import edu.miu.exercise1.entity.Product;
import edu.miu.exercise1.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return null;
    }

    @GetMapping("/filter")
    public List<Product> getProductsByColor(@RequestParam String color) {
        return null;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        // will delete a product by id
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable long id, @RequestBody Product product) {
        // will update a product by id
    }


}
