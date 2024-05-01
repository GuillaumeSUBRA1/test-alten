package com.alten.test.service;

import com.alten.test.entity.Product;
import com.alten.test.mapper.ProductMapper;
import com.alten.test.model.ProductDTO;
import com.alten.test.reposiory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }
    public Product getById(long id){
        return this.productRepository.findById(id).orElse(null);
    }
    public Product save(ProductDTO product){
        return this.productRepository.save(productMapper.productDTOToPruduct(product));
    }
    public void deleteByIds(List<Long> ids){
        for(Long id : ids) {
            this.productRepository.deleteById(id);
        }
    }
}
