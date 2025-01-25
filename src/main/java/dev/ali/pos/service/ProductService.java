package dev.ali.pos.service;

import dev.ali.pos.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductService productService;

    public ProductService(ProductService productService) {
        this.productService = productService;
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public Product findById(Long id){
        return productService.findById(id);
    }

}
