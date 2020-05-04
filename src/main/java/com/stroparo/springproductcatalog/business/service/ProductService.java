package com.stroparo.springproductcatalog.business.service;

import com.stroparo.springproductcatalog.data.entity.Product;
import com.stroparo.springproductcatalog.data.repository.ProductRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  
  ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Iterable<Product> getActiveProductsPage(@NonNull int page, @NonNull int size) {
    return this.productRepository.findProductsByActiveTrue(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "desc"))).getContent();
  }

  public Iterable<Product> getInactiveProductsPage(@NonNull int page, @NonNull int size) {
    return this.productRepository.findProductsByActiveFalse(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "desc"))).getContent();
  }

  public Iterable<Product> getProductsPage(@NonNull int page, @NonNull int size) {
    return this.productRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "desc"))).getContent();
  }
}
