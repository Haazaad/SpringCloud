package ru.haazad.springcloud.product.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.haazad.springcloud.product.service.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
