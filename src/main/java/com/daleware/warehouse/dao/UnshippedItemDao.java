package com.daleware.warehouse.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.daleware.warehouse.model.DynamoDBUnshippedItem;
import com.daleware.warehouse.basic.WareHouseDynamoDBMapper;
import com.daleware.warehouse.model.UnshippedItemConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UnshippedItemDao {
    private static final Logger LOGGER = LogManager.getLogger(UnshippedItemDao.class);

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UnshippedItemDao(WareHouseDynamoDBMapper wareHouseDynamoDBMapper) {
        dynamoDBMapper = wareHouseDynamoDBMapper.getDynamoDBMapper();
    }

    public DynamoDBUnshippedItem loadUnshippedPackage(String userEmail, String trackingNumber_UPCSKU) {
        DynamoDBUnshippedItem unshippedPackage = new DynamoDBUnshippedItem(userEmail, trackingNumber_UPCSKU);
        LOGGER.info(String.format("unshippedPackage for %s has been got from DDB, which is %s ", userEmail, unshippedPackage));

        return dynamoDBMapper.load(unshippedPackage).splitTrackingNumber_UPCSKU();
    }

    public List<DynamoDBUnshippedItem> loadUnshippedPackageByEmail(String userEmail) {
        DynamoDBUnshippedItem unshippedPackage = new DynamoDBUnshippedItem(userEmail);
        LOGGER.info(String.format("unshippedPackage for %s has been got from DDB, which is %s ", userEmail, unshippedPackage));

        String filterExpression = String.format("%s = :email", UnshippedItemConstants.USER_EMAIL);
        Map<String, AttributeValue> expressionAttributeValue = new HashMap<>();
        expressionAttributeValue.put(":email", new AttributeValue().withS(userEmail));

        DynamoDBQueryExpression<DynamoDBUnshippedItem> expression =
                new DynamoDBQueryExpression<DynamoDBUnshippedItem>()
                .withKeyConditionExpression("UserEmail = :email")
                .withExpressionAttributeValues(expressionAttributeValue);

        return dynamoDBMapper.query(DynamoDBUnshippedItem.class, expression)
                .stream()
                .map(unshippedItem -> unshippedItem.splitTrackingNumber_UPCSKU())
                .collect(Collectors.toCollection(ArrayList::new));

    }
}
