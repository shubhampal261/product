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
        ProductResponseModel user = productServiceImpl.getByID(id);
        if(user == null){
            throw new ProductNotFoundException(String.format(ProductConstants.NOT_FOUND_FOR_ID,id));
        }
        return user;
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Product user){
        productServiceImpl.add(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable int id){
        ProductResponseModel user = productServiceImpl.deleteById(id);
        if(user == null){
            throw new ProductNotFoundException(String.format(ProductConstants.CANNOT_DELETE,id));
        }
        return ResponseEntity.noContent().build();
    }

}
