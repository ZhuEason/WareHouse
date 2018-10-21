package com.daleware.warehouse.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.daleware.warehouse.model.DynamoDBUnshippedPackage;
import com.daleware.warehouse.basic.WareHouseDynamoDBMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class UnshippedPackageDao {
    private static final Logger LOGGER = LogManager.getLogger(UnshippedPackageDao.class);

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UnshippedPackageDao(WareHouseDynamoDBMapper wareHouseDynamoDBMapper) {
        dynamoDBMapper = wareHouseDynamoDBMapper.getDynamoDBMapper();
    }

    public DynamoDBUnshippedPackage loadUnshippedPackage(String userEmail, String upcSku) {
        DynamoDBUnshippedPackage unshippedPackage = new DynamoDBUnshippedPackage(userEmail, upcSku);
        LOGGER.info(String.format("unshippedPackage for %s has been got from DDB, which is %s ", userEmail, unshippedPackage));
        return dynamoDBMapper.load(unshippedPackage);
    }
}
