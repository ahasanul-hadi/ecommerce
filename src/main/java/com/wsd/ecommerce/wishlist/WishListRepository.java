package com.wsd.ecommerce.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishListEntity, Long>{
    public List<WishListEntity> findByCustomerId(Long id);
}
