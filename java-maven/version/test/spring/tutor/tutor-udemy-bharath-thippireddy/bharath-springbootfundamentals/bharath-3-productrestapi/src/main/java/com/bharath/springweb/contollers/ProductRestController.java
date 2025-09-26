package com.bharath.springweb.contollers;

import com.bharath.springweb.entities.Product;
import com.bharath.springweb.repos.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

    private final ProductRepository repository;

    public ProductRestController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/")
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    @Transactional(readOnly = true)
    @Cacheable("product-cache")
    public Product getProduct(@PathVariable int id) {
        LOGGER.info("Finding product by ID:" + id);
        Optional<Product> optionalProduct = repository.findById(id);
        return optionalProduct.orElse(null);
    }

    @PostMapping("/products/")
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping("/products/")
    public Product updateProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @DeleteMapping("/products/{id}")
    @CacheEvict("product-cache")
    public void deleteProduct(@PathVariable int id) {
        repository.deleteById(id);
    }

}
