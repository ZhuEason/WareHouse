package com.daleware.warehouse.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName =UnshippedItemConstants.TABLE_NAME)
public class DynamoDBUnshippedItem {
    private final static String DEFAULT_EMPTY_STRING = "";
    private final static Double DEFAULT_DOUBLE_VALUE = 0.0;
    private final static Integer DEFAULT_INTEGER_VALUE = 0;

    private String userEmail;
    private String trackingNumber_UPCSKU;
    private String trackingNumber;
    private String UPCSKU;
    private Integer boxIndex;
    private String checkedDate;
    private String store;

    private Double unitPrice;
    private Integer quantity;
    private String itemName;

    public DynamoDBUnshippedItem() {
    }

    public DynamoDBUnshippedItem(String userEmail) {
        this.userEmail = userEmail;
    }

    public DynamoDBUnshippedItem(String userEmail, String trackingNumber_UPCSKU) {
        this.userEmail = userEmail;
        this.trackingNumber_UPCSKU = trackingNumber_UPCSKU;
        //setDefaultValue();
    }

    private void setDefaultValue() {
        this.boxIndex = DEFAULT_INTEGER_VALUE;
        this.checkedDate = DEFAULT_EMPTY_STRING;
        this.store = DEFAULT_EMPTY_STRING;
        this.unitPrice = DEFAULT_DOUBLE_VALUE;
        this.quantity = DEFAULT_INTEGER_VALUE;
        this.itemName = DEFAULT_EMPTY_STRING;
        this.trackingNumber_UPCSKU = DEFAULT_EMPTY_STRING;
    }

    @DynamoDBHashKey(attributeName = UnshippedItemConstants.USER_EMAIL)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @DynamoDBRangeKey(attributeName = UnshippedItemConstants.TRACKINGNUMBER_UPCSKU)
    public String getTrackingNumber_UPCSKU() {
        return trackingNumber_UPCSKU;
    }

    public void setTrackingNumber_UPCSKU(String trackingNumber_UPCSKU) {
        this.trackingNumber_UPCSKU = trackingNumber_UPCSKU;
    }

    @DynamoDBAttribute(attributeName = UnshippedItemConstants.BOX_INDEX)
    public Integer getBoxIndex() {
        return boxIndex;
    }

    public void setBoxIndex(Integer boxIndex) {
        this.boxIndex = boxIndex;
    }

    @DynamoDBAttribute(attributeName = UnshippedItemConstants.CHECKED_DATE)
    public String getCheckedDate() {
        return checkedDate;
    }

    public void setCheckedDate(String checkedDate) {
        this.checkedDate = checkedDate;
    }

    @DynamoDBAttribute(attributeName = UnshippedItemConstants.STORE)
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @DynamoDBAttribute(attributeName = UnshippedItemConstants.UNIT_PRICE)
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @DynamoDBAttribute(attributeName = UnshippedItemConstants.QUANTITY)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @DynamoDBAttribute(attributeName = UnshippedItemConstants.ITEM_NAME)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public DynamoDBUnshippedItem splitTrackingNumber_UPCSKU() {
        String[] splits = trackingNumber_UPCSKU.split("_");
        setTrackingNumber(splits[0]);
        setUPCSKU(splits[1]);

        return this;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setUPCSKU(String UPCSKU) {
        this.UPCSKU = UPCSKU;
    }

    public String getUPCSKU() {
        return UPCSKU;
    }

}
