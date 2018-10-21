package com.daleware.warehouse.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;

@DynamoDBTable(tableName = "WAREHOUSE_UNSHIPPED_PACKAGE")
public class DynamoDBUnshippedPackage {
    private final static String DEFAULT_EMPTY_STRING = "";
    private final static Double DEFAULT_DOUBLE_VALUE = 0.0;
    private final static Integer DEFAULT_INTEGER_VALUE = 0;

    private String userEmail;
    private String upcSku;
    private Integer boxIndex;
    private String checkedDate;
    private String claimedValue;
    private String store;

    private Double unitPrice;
    private Integer quantity;
    private String itemName;

    private String trackingNumber;

    public DynamoDBUnshippedPackage() {
    }

    public DynamoDBUnshippedPackage(String userEmail) {
        this.userEmail = userEmail;
    }

    public DynamoDBUnshippedPackage(String userEmail, String upcSku) {
        this.userEmail = userEmail;
        this.upcSku = upcSku;
        //setDefaultValue();
    }

    private void setDefaultValue() {
        this.boxIndex = DEFAULT_INTEGER_VALUE;
        this.checkedDate = DEFAULT_EMPTY_STRING;
        this.claimedValue = DEFAULT_EMPTY_STRING;
        this.store = DEFAULT_EMPTY_STRING;
        this.unitPrice = DEFAULT_DOUBLE_VALUE;
        this.quantity = DEFAULT_INTEGER_VALUE;
        this.itemName = DEFAULT_EMPTY_STRING;
        this.trackingNumber = DEFAULT_EMPTY_STRING;
    }

    @DynamoDBHashKey(attributeName = UnshippedPacakgeConstants.USER_EMAIL)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @DynamoDBRangeKey(attributeName = UnshippedPacakgeConstants.UPC_SKU)
    public String getUpcSku() {
        return upcSku;
    }

    public void setUpcSku(String upcSku) {
        this.upcSku = upcSku;
    }

    @DynamoDBAttribute(attributeName = UnshippedPacakgeConstants.BOX_INDEX)
    public Integer getBoxIndex() {
        return boxIndex;
    }

    public void setBoxIndex(Integer boxIndex) {
        this.boxIndex = boxIndex;
    }

    @DynamoDBAttribute(attributeName = UnshippedPacakgeConstants.CHECKED_DATE)
    public String getCheckedDate() {
        return checkedDate;
    }

    public void setCheckedDate(String checkedDate) {
        this.checkedDate = checkedDate;
    }

    @DynamoDBAttribute(attributeName = UnshippedPacakgeConstants.CLAIMED_VALUE)
    public String getClaimedValue() {
        return claimedValue;
    }

    public void setClaimedValue(String claimedValue) {
        this.claimedValue = claimedValue;
    }

    @DynamoDBAttribute(attributeName = UnshippedPacakgeConstants.STORE)
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @DynamoDBAttribute(attributeName = UnshippedPacakgeConstants.UNIT_PRICE)
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @DynamoDBAttribute(attributeName = UnshippedPacakgeConstants.QUANTITY)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @DynamoDBAttribute(attributeName = UnshippedPacakgeConstants.ITEM_NAME)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @DynamoDBAttribute(attributeName = UnshippedPacakgeConstants.TRACKING_NUMBER)
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
