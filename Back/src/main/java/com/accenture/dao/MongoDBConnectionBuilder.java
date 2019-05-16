package com.accenture.dao;

import org.jongo.Jongo;
import org.springframework.data.mongodb.core.MongoOperations;

public interface MongoDBConnectionBuilder {

	public Jongo getnJongoConnection();

	public MongoOperations getnMongoConnection();

}
