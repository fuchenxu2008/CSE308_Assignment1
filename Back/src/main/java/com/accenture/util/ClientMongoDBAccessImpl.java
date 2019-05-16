package com.accenture.util;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.accenture.dao.MongoDBClient;
import com.accenture.model.Client;
import com.accenture.model.Products;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author
 *
 */
public class ClientMongoDBAccessImpl implements ClientMongoDBAccess {

    @Autowired
    MongoDBClient mongoDBClient;

    @Value("${accenture-paas-api.websocketURL}")
    private String websocketURL;

    public ClientMongoDBAccessImpl() {
    }

    private final Logger LOGGER = LoggerFactory.getLogger(ClientMongoDBAccessImpl.class);

    // ==========================================================================================
    // ================================== Clients
    // ========================================
    // ==========================================================================================

    /*
     * (non-Javadoc)
     * 
     * @see com.accenture.util.ClientMongoDBAccess#retrieveAllClients()
     */
    @Override
    public String retrieveAllClients() throws Exception {
        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Dispatching request to retrieveAllClients from mongoDB...");
        }
        ArrayList<Client> clientList = mongoDBClient.retrieveClient(null, null);
        ObjectMapper jsonMapper = Format.getApplicationJsonObjectMapper();
        return jsonMapper.writeValueAsString(clientList);
    }

    @Override
    public String retrieveAllProducts() throws Exception {
        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Dispatching request to retrieveAllProducts from mongoDB...");
        }
        ArrayList<Products> productList = mongoDBClient.retrieveProducts();
        ObjectMapper jsonMapper = Format.getApplicationJsonObjectMapper();
        return jsonMapper.writeValueAsString(productList);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.accenture.util.ClientMongoDBAccess#retrieveSingleClient(java.lang
     * .String)
     */
    @Override
    public String retrieveSingleClient(String clientId, String secretKey) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Dispatching request to retrieveSingleClient from mongoDB...");
        }
        ArrayList<Client> client = mongoDBClient.retrieveClient(clientId, secretKey);
        ObjectMapper jsonMapper = Format.getApplicationJsonObjectMapper();
        return jsonMapper.writeValueAsString(client);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.accenture.util.ClientMongoDBAccess#createClient(com.accenture.model
     * .Client)
     */
    @Override
    public String createClient(Client newClient) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Dispatching request to createClient from mongoDB...");
        }
        Client client = mongoDBClient.createClient(newClient);
        ObjectMapper jsonMapper = Format.getApplicationJsonObjectMapper();
        return jsonMapper.writeValueAsString(client);
    }

    @Override
    public String createProduct(Products newProduct) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Dispatching request to createClient from mongoDB...");
        }
        Products product = mongoDBClient.createProduct(newProduct);
        ObjectMapper jsonMapper = Format.getApplicationJsonObjectMapper();
        return jsonMapper.writeValueAsString(product);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.accenture.util.ClientMongoDBAccess#updateClient(com.accenture.model
     * .Client)
     */
    @Override
    public String updateClient(Client clientData) throws Exception {

        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Dispatching request to updateClient from mongoDB...");
        }
        ;
        Client client = mongoDBClient.updateClient(clientData);
        String clientId = client.getClientId();
        ObjectMapper jsonMapper = Format.getApplicationJsonObjectMapper();

        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("websocketURL " + websocketURL);
        }
        return jsonMapper.writeValueAsString(client);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.accenture.util.ClientMongoDBAccess#deleteClient(java.lang.String)
     */
    @Override
    public String deleteClient(String clientId) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Dispatching request to deleteClient from mongoDB...");
        }
        Boolean deleted = mongoDBClient.deleteClient(clientId);
        ObjectMapper jsonMapper = Format.getApplicationJsonObjectMapper();
        return jsonMapper.writeValueAsString(deleted);
    }

    @Override
    public String retrieveSingleClient(String clientId) throws IOException, Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String retrieveSingleProduct(String id) throws Exception {
        if (LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("Dispatching request to retrieveSingleClient from mongoDB...");
        }
        ArrayList<Products> product = mongoDBClient.retrieveProduct(id);
        ObjectMapper jsonMapper = Format.getApplicationJsonObjectMapper();
        return jsonMapper.writeValueAsString(product);
    }

}
