package com.example.suprasysapi.controllers;

import java.util.Optional;

import com.example.suprasysapi.domain.Product;
import com.example.suprasysapi.dtos.ProductDTO;
import com.example.suprasysapi.services.ProductService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/products")
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        Product product = new Product();

        BeanUtils.copyProperties(productDTO, product);

        service.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> list(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> show(@PathVariable(value = "id") Integer id) {
        Optional<Product> productOptional = service.findById(id);

        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(productOptional.get());
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody ProductDTO productDTO) {
        Product product = new Product();

        BeanUtils.copyProperties(productDTO, product);

        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
