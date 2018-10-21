package com.daleware.warehouse.basic;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.daleware.warehouse.basic.WareHouseDynamoDBClient;
import org.springframework.beans.factory.annotation.Autowired;

public class WareHouseDynamoDBMapper {
    private DynamoDBMapper wareHouseDynamoDBMapper;

    @Autowired
    public WareHouseDynamoDBMapper(WareHouseDynamoDBClient wareHouseDynamoDBClient) {
        this.wareHouseDynamoDBMapper = new DynamoDBMapper(wareHouseDynamoDBClient.getDynamoDBClient());
    }

    public DynamoDBMapper getDynamoDBMapper() {
        return wareHouseDynamoDBMapper;
    }
}
