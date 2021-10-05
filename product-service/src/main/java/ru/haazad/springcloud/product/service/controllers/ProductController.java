package ru.haazad.springcloud.product.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.haazad.springcloud.product.service.dtos.ProductServiceDto;
import ru.haazad.springcloud.product.service.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductServiceDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductServiceDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
