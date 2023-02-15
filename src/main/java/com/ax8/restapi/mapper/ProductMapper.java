package com.ax8.restapi.mapper;

import com.ax8.restapi.domain.Product;
import com.ax8.restapi.domain.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getLength(),
                productDto.getWidth()
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getLength(),
                product.getWidth()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .toList();
    }
}
