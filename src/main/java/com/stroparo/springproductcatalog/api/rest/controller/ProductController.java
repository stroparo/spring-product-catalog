package com.stroparo.springproductcatalog.api.rest.controller;

import com.stroparo.springproductcatalog.business.service.ProductService;
import com.stroparo.springproductcatalog.data.entity.Product;
import com.stroparo.springproductcatalog.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.stroparo.springproductcatalog.data.constants.ProductRestControllerConstants.PAGE_SIZE_PRODUCT;

@RestController
@RequestMapping({"/", "/product"})
public class ProductController {
  
  @Autowired
  private ProductRepository productRepository;
  
  @Autowired
  private ProductService productService;
  
  @GetMapping("/{id:[1-9][0-9]*}")
  public Optional<Product> getProduct(@PathVariable long id) {
    return productRepository.findById(id);
  }

  @GetMapping()
  public Iterable<Product> getProducts(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
    return productService.getProductsPage(page < 1 ? 0 : page - 1, PAGE_SIZE_PRODUCT);
  }

  @GetMapping("/active")
  public Iterable<Product> getActiveProducts(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
    return productService.getActiveProductsPage(page < 1 ? 0 : page - 1, PAGE_SIZE_PRODUCT);
  }

  @GetMapping("/inactive")
  public Iterable<Product> getInactiveProducts(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
    return productService.getInactiveProductsPage(page < 1 ? 0 : page - 1, PAGE_SIZE_PRODUCT);
  }

}
