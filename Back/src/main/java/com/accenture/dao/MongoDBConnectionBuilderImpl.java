package com.accenture.dao;

import org.jongo.Jongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDBConnectionBuilderImpl implements InitializingBean, MongoDBConnectionBuilder {
    private final Logger LOGGER = LoggerFactory.getLogger(MongoDBConnectionBuilderImpl.class);

    MongoOperations mongoOperation;

    Jongo jongo;

    @Value("${accenture-paas-api.db.host}")
    private String dbHost;

    @Value("${accenture-paas-api.db.port}")
    private int dbPort;

    @Value("${accenture-paas-api.db.databaseName}")
    private String databaseName;

    @Value("${accenture-paas-api.db.test.useDatabase}")
    private String databaseType;

    @Value("${accenture-paas-api.db.test.databaseName}")
    private String testDatabaseName;

    @Override
    public void afterPropertiesSet() throws Exception {

        // Create a Jongo Connection
        MongoClientURI uri = new MongoClientURI("mongodb://root:fcx20121221@kyrie.top:27017/?authSource=admin");
        MongoClient mc = new MongoClient(uri);
        // MongoCredential credential = MongoCredential.createCredential("root",
        // databaseName, "puchi2019".toCharArray());
        // MongoClient mc = new MongoClient(new ServerAddress(dbHost, dbPort),
        // Arrays.asList(credential));
        // MongoClient mc = new MongoClient(dbHost, dbPort);
        DB db = null;

        if (databaseType.equalsIgnoreCase("testDatabase")) {
            db = mc.getDB(testDatabaseName);
            if (LOGGER.isDebugEnabled()) {
                this.LOGGER.debug("testDatabaseName: " + testDatabaseName + " Host: " + dbHost);
            }
        } else {
            db = mc.getDB(databaseName);
            // MongoDatabase database = mc.getDatabase(databaseName);
            if (LOGGER.isDebugEnabled()) {
                this.LOGGER.debug("databaseName:" + databaseName + "  Host: " + dbHost);
            }
        }
        // Jongo API entry point
        jongo = new Jongo(db);

        // Create a MongoDB Java driver connection
        SpringMongoConfig.databaseName = databaseName;
        SpringMongoConfig.dbHost = dbHost;

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        // ctx.close();

    }

    @Override
    public MongoOperations getnMongoConnection() {
        return mongoOperation;

    }

    @Override
    public Jongo getnJongoConnection() {
        return jongo;

    }

}
