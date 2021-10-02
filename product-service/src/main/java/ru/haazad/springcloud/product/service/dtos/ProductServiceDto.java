package ru.haazad.springcloud.product.service.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.haazad.springcloud.common.dtos.ProductDto;
import ru.haazad.springcloud.product.service.models.Product;

@Data
@NoArgsConstructor
@JsonSerialize(as = ProductDto.class)
public class ProductServiceDto extends ProductDto {
    public ProductServiceDto(Product product) {
        this.setId(product.getId());
        this.setTitle(product.getTitle());
        this.setPrice(product.getPrice());
        this.setCreateDate(product.getCreateDate());
        this.setUpdateDate(product.getUpdateDate());
    }
}
