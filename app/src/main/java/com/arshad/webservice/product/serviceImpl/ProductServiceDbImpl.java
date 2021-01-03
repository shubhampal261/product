package com.arshad.webservice.product.serviceImpl;

import com.arshad.webservice.product.beans.Product;
import com.arshad.webservice.product.beans.ProductResponseModel;
import com.arshad.webservice.product.mapper.ProductMapper;
import com.arshad.webservice.product.repo.ProductJPARepository;
import com.arshad.webservice.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("productServiceDbImpl")
public class ProductServiceDbImpl implements ProductService {

    @Autowired
    private ProductJPARepository productRepository;

    public List<ProductResponseModel> getAll() {
        List<ProductResponseModel> productList = ProductMapper.INSTANCE.mapToUserResponseModelList(productRepository.findAll());
        return productList;
    }

    public ProductResponseModel getByID(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return ProductMapper.INSTANCE.mapToUserResponseModel(productOptional.get());
        }
        return null;
    }

    public ProductResponseModel add(Product product) {
        product = productRepository.save(product);
        return ProductMapper.INSTANCE.mapToUserResponseModel(product);
    }

    @Override
    public ProductResponseModel deleteById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
            return ProductMapper.INSTANCE.mapToUserResponseModel(product);
        }
        return null;
    }

}

