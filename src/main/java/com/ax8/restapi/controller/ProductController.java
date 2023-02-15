package com.ax8.restapi.controller;

import com.ax8.restapi.domain.Product;
import com.ax8.restapi.domain.ProductDto;
import com.ax8.restapi.mapper.ProductMapper;
import com.ax8.restapi.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final DbService service;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productMapper.mapToProductDtoList(service.getAllProducts()));
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProducts(@PathVariable Long productId) throws ProductNotFoundException {
        Product product = service.getProduct(productId);
        return ResponseEntity.ok(productMapper.mapToProductDto(product));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) throws ProductNotFoundException {
        service.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = service.saveProduct(product);
        return ResponseEntity.ok(productMapper.mapToProductDto(savedProduct));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        service.saveProduct(product);
        return ResponseEntity.ok().build();
    }
}
