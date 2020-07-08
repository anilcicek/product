package com.anil.product.base.product;

import com.anil.product.base.RequestResponseType;
import com.anil.product.entity.Product;

import java.util.List;

public class SearchProductResponseType {

    RequestResponseType requestResponseType;
    List<Product> resultList;

    public RequestResponseType getRequestResponseType() {
        return requestResponseType;
    }

    public void setRequestResponseType(RequestResponseType requestResponseType) {
        this.requestResponseType = requestResponseType;
    }

    public List<Product> getResultList() {
        return resultList;
    }

    public void setResultList(List<Product> resultList) {
        this.resultList = resultList;
    }
}
