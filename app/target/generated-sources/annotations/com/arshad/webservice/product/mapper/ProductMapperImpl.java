package com.arshad.webservice.product.mapper;

import com.arshad.webservice.product.beans.Product;
import com.arshad.webservice.product.beans.ProductResponseModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-01T21:48:57+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponseModel mapToUserResponseModel(Product user) {
        if ( user == null ) {
            return null;
        }

        ProductResponseModel productResponseModel = new ProductResponseModel();

        productResponseModel.setId( user.getId() );
        productResponseModel.setName( user.getName() );
        productResponseModel.setCode( user.getCode() );

        return productResponseModel;
    }

    @Override
    public List<ProductResponseModel> mapToUserResponseModelList(List<Product> userList) {
        if ( userList == null ) {
            return null;
        }

        List<ProductResponseModel> list = new ArrayList<ProductResponseModel>( userList.size() );
        for ( Product product : userList ) {
            list.add( mapToUserResponseModel( product ) );
        }

        return list;
    }
}
