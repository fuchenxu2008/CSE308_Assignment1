package com.accenture.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.accenture.model.Client;
import com.accenture.model.Products;
import com.accenture.util.exception.ItemCreateException;

public interface MongoDBClient {

    public abstract void setBuilder(MongoDBConnectionBuilder builder);

    public abstract ArrayList<Client> retrieveClient(String clientId) throws IOException, Exception;

    public abstract Client createClient(Client newClient) throws ItemCreateException, IOException, Exception;

    public abstract Client updateClient(Client clientData) throws Exception;

    public abstract Boolean deleteClient(String clientId) throws IOException, Exception;

    public abstract ArrayList<Client> retrieveClient(String clientId, String secretKey) throws Exception;

    public abstract Products createProduct(Products newProduct) throws Exception;

    public abstract ArrayList<Products> retrieveProducts() throws Exception;

    public abstract ArrayList<Products> retrieveProduct(String productId) throws Exception;
}