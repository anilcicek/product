package com.anil.product.base;

public class BaseUtils {

    public static boolean isOperationSuccess(RequestResponseType requestResponseType){

        if(requestResponseType.getReturnCode()==GeneralEnumaration.InternalReturnCodes.SUCCESS.getReturnCode()){
            return true;
        }

        return  false;
    }
}
