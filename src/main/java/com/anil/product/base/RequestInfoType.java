package com.anil.product.base;

public class RequestInfoType {

    private boolean validateRequired;
    private int userId;

    public boolean isValidateRequired() {
        return validateRequired;
    }

    public void setValidateRequired(boolean validateRequired) {
        this.validateRequired = validateRequired;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
