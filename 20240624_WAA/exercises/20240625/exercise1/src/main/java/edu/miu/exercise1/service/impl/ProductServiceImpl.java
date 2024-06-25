package edu.miu.exercise1.service.impl;

import edu.miu.exercise1.entity.Product;
import edu.miu.exercise1.repository.ProductRepo;
import edu.miu.exercise1.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void save(Product product) {
        if (product.getPrice() < 0) {
            throw new RuntimeException("Price cannot be negative");
        }

        productRepo.save(product);
    }
}
