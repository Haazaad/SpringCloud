package ru.haazad.springcloud.front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.haazad.springcloud.common.dtos.ProductDto;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/products/v1")
@EnableEurekaClient
public class FrontServiceApplication {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {return new RestTemplate();}

    public static void main(String[] args) {
        SpringApplication.run(FrontServiceApplication.class, args);
    }

    @GetMapping()
    public List<ProductDto> getAllProducts() {
        return restTemplate.getForObject("http://product-service/api/v1/products", ArrayList.class);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return restTemplate.getForObject("http://product-service/api/v1/products/" + id, ProductDto.class);
    }
}
