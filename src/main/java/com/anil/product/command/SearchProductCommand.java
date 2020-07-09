package com.anil.product.command;

import com.anil.product.base.GeneralEnumaration;
import com.anil.product.base.RequestInfoType;
import com.anil.product.base.RequestResponseType;
import com.anil.product.base.product.SearchProductResponseType;
import com.anil.product.entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProductCommand extends BaseProductCommand {

    Collection<Product> productList;
    String searchKey;
    String searchVal;
    String direction;
    SearchProductResponseType searchProductResponseType;


    public SearchProductCommand(RequestInfoType requestInfoType, Collection<Product> productList, String searchKey , String searchVal ){
        super(requestInfoType);
        this.productList = productList;
        this.searchKey=searchKey;
        this.searchVal=searchVal;
        searchProductResponseType = new SearchProductResponseType();
        this.validateRequestInfo();

    }

    public SearchProductCommand(RequestInfoType requestInfoType, Collection<Product> productList, String searchKey , String searchVal , String direction ){
        super(requestInfoType);
        this.productList = productList;
        this.searchKey=searchKey;
        this.searchVal=searchVal;
        this.direction=direction;
        searchProductResponseType = new SearchProductResponseType();
        this.validateRequestInfo();

    }

    public void processCommand(){

        if(this.requestInfoValid){
            this.doProcess();
        }

    }

    private void doProcess(){

        RequestResponseType response = new RequestResponseType();
        searchProductResponseType.setRequestResponseType(response);
        List<Product> resultList = new ArrayList<>();

        try{

            if(GeneralEnumaration.ProductSearchType.CATEGORY.getSearchKey().equals(searchKey)){
                resultList=  this.getProductByCategoryCode();

            }else if(GeneralEnumaration.ProductSearchType.PRICE.getSearchKey().equals(searchKey)){
                resultList=  this.getProductByPrice();
            }

            if(resultList!=null && !resultList.isEmpty()){

                searchProductResponseType.setResultList(resultList);
                response.setReturnCode(GeneralEnumaration.InternalReturnCodes.SUCCESS.getReturnCode());
                response.setReturnMessage(GeneralEnumaration.InternalReturnCodes.SUCCESS.toString());

            }else{

                response.setReturnCode(GeneralEnumaration.InternalReturnCodes.INQUIRE_NO_RECORD.getReturnCode());
                response.setReturnMessage(GeneralEnumaration.InternalReturnCodes.INQUIRE_NO_RECORD.toString());

            }

        }catch (Exception e){

            response.setReturnCode(GeneralEnumaration.InternalReturnCodes.ERROR.getReturnCode());
            response.setReturnMessage(GeneralEnumaration.InternalReturnCodes.ERROR.toString());

        }


    }

    private List<Product> getProductByCategoryCode(){

        List<Product> filteredList;
        filteredList = this.productList.stream().filter(p -> searchVal.equals(p.getCategory())).collect(Collectors.toList());
        return filteredList;
    }

    private List<Product> getProductByPrice(){

        List<Product> filteredList = null;

        if(GeneralEnumaration.ProductPriceSearchDirection.GREATER.getDirection().equals(direction)){

            filteredList = this.productList.stream().filter(p -> Integer.parseInt(searchVal)< p.getPrice()).collect(Collectors.toList());

        }else if(GeneralEnumaration.ProductPriceSearchDirection.LESS.getDirection().equals(direction)){

            filteredList = this.productList.stream().filter(p -> Integer.parseInt(searchVal)> p.getPrice()).collect(Collectors.toList());
        }

        return filteredList;
    }

    public SearchProductResponseType getResult(){
        return this.searchProductResponseType;
    }

}
