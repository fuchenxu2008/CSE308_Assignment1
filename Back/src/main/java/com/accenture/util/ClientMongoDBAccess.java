package com.accenture.util;

import java.io.IOException;

import com.accenture.model.Client;
import com.accenture.model.Products;
import com.accenture.util.exception.ItemCreateException;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ClientMongoDBAccess {

    /**
     * Retrieve all clients in the mongoDB by dispatching a request to the
     * mongoDB server
     * 
     * @return
     * @throws IOException
     * @throws Exception
     */
    public abstract String retrieveAllClients() throws IOException, ItemCreateException, Exception;

    /**
     * Retrieve a single client in the mongoDB by dispatching a request to the
     * mongoDB server
     * 
     * @param clientId
     * @return
     * @throws ObjectDoesNotExistException
     * @throws IOException
     * @throws Exception
     */
    public abstract String retrieveSingleClient(String clientId) throws IOException, Exception;

    /**
     * Create a singel client in the mongoDB by dispatching a request to the
     * mongoDB server
     * 
     * @return
     * @throws Exception
     */
    public abstract String createClient(Client newClient) throws ItemCreateException, IOException, Exception;

    /**
     * Update a single client in the mongoDB by dispatching a request to the
     * mongoDB server
     * 
     * @param clientData
     * @return
     * @throws JsonProcessingException
     * @throws Exception
     * @throws ObjectDoesNotExistException
     */
    public abstract String updateClient(Client clientData) throws JsonProcessingException, Exception;

    /**
     * Deactivate a single client in the mongoDB by dispatching a request to the
     * mongoDB server
     * 
     * @param clientId
     * @return
     * @throws JsonProcessingException
     * @throws IOException
     * @throws Exception
     */
    public abstract String deleteClient(String clientId) throws JsonProcessingException, IOException, Exception;

    String retrieveSingleClient(String clientId, String secretKey) throws Exception;

    String retrieveAllProducts() throws Exception;

    String createProduct(Products newProduct) throws Exception;

    String retrieveSingleProduct(String id) throws Exception;

}