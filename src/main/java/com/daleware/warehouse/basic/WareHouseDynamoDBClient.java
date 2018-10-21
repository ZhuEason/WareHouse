package com.daleware.warehouse.basic;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;


public class WareHouseDynamoDBClient {
    private static Regions region = Regions.US_EAST_1;

    private AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.standard()
            .withRegion(region)
            .build();

    public AmazonDynamoDB getDynamoDBClient () {
        return dynamoDB;
    }
}
