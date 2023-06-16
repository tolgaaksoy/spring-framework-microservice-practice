package com.tolgaaksoy.productservice.controller;

import com.tolgaaksoy.productservice.model.dto.request.ProductRequest;
import com.tolgaaksoy.productservice.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity createProduct(@RequestBody ProductRequest productRequest) {
    productService.createProduct(productRequest);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Page> getProduct(Pageable pageable) {
    return new ResponseEntity<>(productService.getProductPage(pageable), HttpStatus.OK);
  }

}
