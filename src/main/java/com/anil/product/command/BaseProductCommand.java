package com.anil.product.command;

import com.anil.product.base.RequestInfoType;

public class BaseProductCommand {

    RequestInfoType requestInfoType;

    public BaseProductCommand(RequestInfoType requestInfoType){
        this.requestInfoType = requestInfoType;
    }


    boolean requestInfoValid=false;

    public boolean isRequestInfoValid() {
        return requestInfoValid;
    }

    public void setRequestInfoValid(boolean requestInfoValid) {
        this.requestInfoValid = requestInfoValid;
    }

    public void validateRequestInfo(){

        if(this.requestInfoType.isValidateRequired()){

            if(this.requestInfoType.getUserId()>0){
                this.requestInfoValid=true;
            }

        }

        this.requestInfoValid=true;

    }
}
