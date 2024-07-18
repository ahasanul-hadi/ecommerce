package com.wsd.ecommerce.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<ProductEntity> findById(Long id){
        return productRepository.findById(id);
    }
}
