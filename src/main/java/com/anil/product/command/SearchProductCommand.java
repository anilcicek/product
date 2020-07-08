package com.anil.product.command;

import com.anil.product.base.GeneralEnumaration;
import com.anil.product.base.RequestInfoType;
import com.anil.product.base.RequestResponseType;
import com.anil.product.base.product.SearchProductResponseType;
import com.anil.product.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchProductCommand extends BaseProductCommand {

    List<Product> productList;
    String searchKey;
    RequestResponseType response;
    SearchProductResponseType searchProductResponseType;


    public SearchProductCommand(RequestInfoType requestInfoType, List<Product> productList, String searchKey ){
        super(requestInfoType);
        this.productList = productList;
        this.searchKey=searchKey;
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



            }

            if(resultList!=null && !resultList.isEmpty()){

                searchProductResponseType.setResultList(resultList);
                response.setReturnCode(GeneralEnumaration.InternalReturnCodes.INQUIRE_NO_RECORD.getReturnCode());
                response.setReturnMessage(GeneralEnumaration.InternalReturnCodes.INQUIRE_NO_RECORD.toString());

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



        return null;
    }

    public SearchProductResponseType getResult(){

        return this.searchProductResponseType;
    }

}
