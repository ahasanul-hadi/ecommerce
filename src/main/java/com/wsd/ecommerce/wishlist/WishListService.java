package com.wsd.ecommerce.wishlist;

import com.wsd.ecommerce.customer.CustomerEntity;
import com.wsd.ecommerce.customer.CustomerRepository;
import com.wsd.ecommerce.customer.CustomerService;
import com.wsd.ecommerce.exception.ApplicationException;
import com.wsd.ecommerce.payload.request.WishListRequest;
import com.wsd.ecommerce.product.ProductEntity;
import com.wsd.ecommerce.product.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;
    private final ModelMapper modelMapper;
    private final CustomerService customerService;
    private final ProductService productService;
    private final CustomerRepository customerRepository;

    public WishListDTO save(WishListRequest wish) {
        CustomerEntity customer= customerService.findById(wish.getCustomerID()).orElseThrow(()-> new ApplicationException("No customer found!", HttpStatus.NOT_FOUND));
        ProductEntity product= productService.findById(wish.getProductID()).orElseThrow(()-> new ApplicationException("No Product found!", HttpStatus.NOT_FOUND));

        WishListEntity entity= new WishListEntity();
        entity.setCustomer(customer);
        entity.setProduct(product);
        entity.setDateTime(wish.getDateTime());

        return mapToDTO( wishListRepository.save(entity) );


    }

    public List<WishListDTO> findByCustomer(Long id){
        return wishListRepository.findByCustomerId(id).stream().map(this::mapToDTO).toList();
    }

    private WishListDTO mapToDTO(WishListEntity entity) {
        return modelMapper.map(entity, WishListDTO.class);
    }
}
