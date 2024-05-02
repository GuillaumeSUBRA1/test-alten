package com.alten.test.model;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
