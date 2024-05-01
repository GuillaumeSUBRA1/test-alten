package com.alten.test.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ProductDTO {
    public long id;
    public String code;
    public String name;
    public String description;
    public int price;
    public int quantity;
    public String inventoryStatus;
    public String category;
    public String image;
    public int rating;

}
