package com.arshad.webservice.product.repo;

import com.arshad.webservice.product.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepository extends JpaRepository<Product, Integer>  {
}

