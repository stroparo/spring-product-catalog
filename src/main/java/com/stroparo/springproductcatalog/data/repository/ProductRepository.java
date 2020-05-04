package com.stroparo.springproductcatalog.data.repository;

import com.stroparo.springproductcatalog.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
  Page<Product> findProductsByActiveFalse(Pageable pageable);
  Page<Product> findProductsByActiveTrue(Pageable pageable);
}
