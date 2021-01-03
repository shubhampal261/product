package com.arshad.webservice.product.controllers;

import com.arshad.webservice.product.beans.Product;
import com.arshad.webservice.product.beans.ProductResponseModel;
import com.arshad.webservice.product.services.ProductService;
import com.arshad.webservice.product.utils.ProductConstants;
import com.arshad.webservice.product.utils.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "v1/product")
public class ProductController {

    @Autowired
    @Qualifier(value = "productServiceDbImpl")
    private ProductService productServiceImpl;

    @GetMapping()
    public List<ProductResponseModel> getAll(){
        return productServiceImpl.getAll();
    }

    @GetMapping(path = "/{id}")
    public ProductResponseModel getById(@PathVariable int id){
        ProductResponseModel product = productServiceImpl.getByID(id);
        if(product == null){
            throw new ProductNotFoundException(String.format(ProductConstants.NOT_FOUND_FOR_ID,id));
        }
        return product;
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Product product){
        productServiceImpl.add(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable int id){
        ProductResponseModel product = productServiceImpl.deleteById(id);
        if(product == null){
            throw new ProductNotFoundException(String.format(ProductConstants.CANNOT_DELETE,id));
        }
        return ResponseEntity.noContent().build();
    }

}
