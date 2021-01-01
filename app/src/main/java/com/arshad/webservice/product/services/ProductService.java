package com.arshad.webservice.product.services;

import com.arshad.webservice.product.beans.Product;
import com.arshad.webservice.product.beans.ProductResponseModel;

import java.util.List;

public interface ProductService {

    public List<ProductResponseModel> getAll();

    public ProductResponseModel getByID(int id);

    public ProductResponseModel add(Product user);

    public ProductResponseModel deleteById(int id);
}
