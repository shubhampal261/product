package com.arshad.webservice.product.mapper;

import com.arshad.webservice.product.beans.Product;
import com.arshad.webservice.product.beans.ProductResponseModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponseModel mapToUserResponseModel(final Product user);

    List<ProductResponseModel> mapToUserResponseModelList(final List<Product> userList);
}
