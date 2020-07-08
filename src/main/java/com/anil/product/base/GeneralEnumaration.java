package com.anil.product.base;

public class GeneralEnumaration {

    public enum ProductCategory{

        SHOE("SHOE"),
        ACCESSORY("ACCESSORY"),
        BAG("BAG"),
        CLOTHING("CLOTHING");

        private String categoryCode;

        ProductCategory(String categoryCode){
            this.categoryCode=categoryCode;
        }

        public String getCategoryCode() {
            return categoryCode;
        }
    }

    public enum ProductSearchType{

        CATEGORY("CATEGORY");

        private String searchKey;

        ProductSearchType(String searchKey){
            this.searchKey=searchKey;
        }

        public String getSearchKey() {
            return searchKey;
        }
    }

    public enum InternalReturnCodes{

        SUCCESS(100),
        ERROR(9999),
        INQUIRE_NO_RECORD(1010);

        public int getReturnCode() {
            return returnCode;
        }

        private int returnCode;

        InternalReturnCodes(int returnCode){
            this.returnCode=returnCode;
        }

    }


}
