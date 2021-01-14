package com.arshad.webservice.product.mapper;

import com.arshad.webservice.product.beans.Product;
import com.arshad.webservice.product.beans.ProductResponseModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-15T01:36:06+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponseModel mapToProductResponseModel(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseModel productResponseModel = new ProductResponseModel();

        productResponseModel.setId( product.getId() );
        productResponseModel.setName( product.getName() );
        productResponseModel.setCode( product.getCode() );
        productResponseModel.setRate( product.getRate() );

        return productResponseModel;
    }

    @Override
    public List<ProductResponseModel> mapToProductResponseModelList(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<ProductResponseModel> list = new ArrayList<ProductResponseModel>( productList.size() );
        for ( Product product : productList ) {
            list.add( mapToProductResponseModel( product ) );
        }

        return list;
    }
}
