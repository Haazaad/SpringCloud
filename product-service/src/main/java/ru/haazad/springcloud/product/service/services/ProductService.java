package ru.haazad.springcloud.product.service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.haazad.springcloud.product.service.dtos.ProductServiceDto;
import ru.haazad.springcloud.product.service.exceptions.ResourceNotFoundException;
import ru.haazad.springcloud.product.service.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductServiceDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductServiceDto::new).collect(Collectors.toList());
    }

    public ProductServiceDto getProductById(Long productId) {
        return productRepository.findById(productId).map(ProductServiceDto::new).orElseThrow(() -> new ResourceNotFoundException("Product with id=" + productId + " not found."));
    }
}
