package com.tolgaaksoy.productservice.service.impl;

import com.tolgaaksoy.productservice.model.dto.request.ProductRequest;
import com.tolgaaksoy.productservice.model.entity.Product;
import com.tolgaaksoy.productservice.repository.ProductRepository;
import com.tolgaaksoy.productservice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void createProduct(ProductRequest productRequest) {

    Product product = new Product();
    product.setName(productRequest.getName());
    product.setDescription(productRequest.getDescription());
    product.setPrice(productRequest.getPrice());

    productRepository.save(product);

    log.info("Product created: {}", product);
  }

  @Override
  public Page<Product> getProductPage(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

}
