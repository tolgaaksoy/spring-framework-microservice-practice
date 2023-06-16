package com.tolgaaksoy.productservice.service;

import com.tolgaaksoy.productservice.model.dto.request.ProductRequest;
import com.tolgaaksoy.productservice.model.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
  void createProduct(ProductRequest productRequest);

  Page<Product> getProductPage(Pageable pageable);
}
