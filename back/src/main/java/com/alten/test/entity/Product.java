package com.alten.test.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="product")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public long id;

    @Column(name = "code")
    public String code;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "price")
    public int price;

    @Column(name = "quantity")
    public int quantity;

    @Column(name = "inventory_status")
    public String inventoryStatus;

    @Column(name = "category")
    public String category;

    @Column(name = "image", nullable = true)
    public String image;

    @Column(name = "rating", nullable = true)
    public int rating;
}
