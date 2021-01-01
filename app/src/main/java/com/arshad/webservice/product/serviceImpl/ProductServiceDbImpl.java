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
@Qualifier("userServiceDbImpl")
public class ProductServiceDbImpl implements ProductService {

    @Autowired
    private ProductJPARepository userRepository;

    public List<ProductResponseModel> getAll() {
        List<ProductResponseModel> userList = ProductMapper.INSTANCE.mapToUserResponseModelList(userRepository.findAll());
        return userList;
    }

    public ProductResponseModel getByID(int id) {
        Optional<Product> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return ProductMapper.INSTANCE.mapToUserResponseModel(userOptional.get());
        }
        return null;
    }

    public ProductResponseModel add(Product product) {
        product = userRepository.save(product);
        return ProductMapper.INSTANCE.mapToUserResponseModel(product);
    }

    @Override
    public ProductResponseModel deleteById(int id) {
        Optional<Product> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            Product product = userOptional.get();
            userRepository.delete(product);
            return ProductMapper.INSTANCE.mapToUserResponseModel(product);
        }
        return null;
    }

}

