package com.ax8.restapi.service;

import com.ax8.restapi.controller.ProductNotFoundException;
import com.ax8.restapi.domain.Product;
import com.ax8.restapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProduct(Long productId) throws ProductNotFoundException {
        return repository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    public void deleteProduct(Long productId) {
        repository.deleteById(productId);
    }

    public Product saveProduct(final Product product) {
        return repository.save(product);
    }
}
