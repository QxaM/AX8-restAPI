package com.ax8.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String productName;
    private double length;
    private double width;
}
