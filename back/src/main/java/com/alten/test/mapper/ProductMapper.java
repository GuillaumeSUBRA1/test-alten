package com.alten.test.mapper;

import com.alten.test.entity.Product;
import com.alten.test.model.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface ProductMapper {
    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "code", source = "product.code")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "quantity", source = "product.quantity")
    @Mapping(target = "inventoryStatus", source = "product.inventoryStatus")
    @Mapping(target = "category", source = "product.category")
    @Mapping(target = "image", source = "product.image")
    @Mapping(target = "rating", source = "product.rating")
    ProductDTO productToProductDTO(Product product);

    @Mapping(target = "id", source = "productDTO.id")
    @Mapping(target = "code", source = "productDTO.code")
    @Mapping(target = "name", source = "productDTO.name")
    @Mapping(target = "description", source = "productDTO.description")
    @Mapping(target = "price", source = "productDTO.price")
    @Mapping(target = "quantity", source = "productDTO.quantity")
    @Mapping(target = "inventoryStatus", source = "productDTO.inventoryStatus")
    @Mapping(target = "category", source = "productDTO.category")
    @Mapping(target = "image", source = "productDTO.image")
    @Mapping(target = "rating", source = "productDTO.rating")
    Product productDTOToPruduct(ProductDTO productDTO);
}
