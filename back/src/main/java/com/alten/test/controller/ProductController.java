package com.alten.test.controller;

import com.alten.test.entity.Product;
import com.alten.test.model.ProductDTO;
import com.alten.test.reposiory.ProductRepository;
import com.alten.test.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/products")
@NoArgsConstructor
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getAll());
    }

    @PatchMapping("/save")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO productDTO){
       return ResponseEntity.ok(productService.save(productDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable("id") long id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody List<Long> ids){
        productService.deleteByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}