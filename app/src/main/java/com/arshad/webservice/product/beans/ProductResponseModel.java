package com.arshad.webservice.product.beans;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProductResponseModel {

    private int id;
    private String name;
    private String code;

    public ProductResponseModel() {
    }

    public ProductResponseModel(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return "ProductResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
