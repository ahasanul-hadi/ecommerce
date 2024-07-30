package com.wsd.ecommerce.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Long> {

    Optional<SalesEntity> findByYearAndMonthAndDayAndProductID(int year, int month, int day, Long productID);

    @Query(value = "SELECT sum(amount) as totalAmount from sales_summary where year= ?1 and month= ?2 and day= ?3", nativeQuery = true)
    BigDecimal findByYearAndMonthAndDay(int year, int month, int day);
}
