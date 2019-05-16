package com.accenture.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jongo.Jongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.mongodb.core.MongoOperations;

import com.accenture.model.Client;
import com.accenture.model.Products;

public class MongoDBClientImpl implements InitializingBean, MongoDBClient {

    private final Logger LOGGER = LoggerFactory.getLogger(MongoDBClientImpl.class);

    private MongoDBConnectionBuilder builder;

    /*
     * (non-Javadoc)
     * 
     * @see com.accenture.dao.MongoDBClient#setBuilder(com.accenture.dao.
     * MongoDBConnectionBuilder)
     */

    MongoOperations mongoOperation;

    Jongo jongo;

    /*
     * (non-Javadoc)
     * 
     * @see com.accenture.dao.MongoDBClient#retrieveClient(java.lang.String)
     */

    public ArrayList<Client> retrieveClient(String clientId, String secretKey) throws Exception {

        jongo = builder.getnJongoConnection();

        System.out.println("jongo " + jongo);
        ArrayList<Client> clients = new ArrayList<Client>();

        org.jongo.MongoCursor<Client> clientList = null;

        org.jongo.MongoCollection allClient;
        allClient = jongo.getCollection("client");

        if (clientId != null) {
            clientList = allClient.find("{clientId:#,secretKey:#}", clientId, secretKey).as(Client.class);
        } else {
            clientList = allClient.find().as(Client.class);
        }

        Iterator<Client> client_iter = clientList.iterator();
        while (client_iter.hasNext()) {
            Client client = client_iter.next();
            clients.add(client);
        }
        clientList.close();
        System.out.println("clients: " + clients);
        return clients;

    }

    public ArrayList<Products> retrieveProducts() throws Exception {

        jongo = builder.getnJongoConnection();

        System.out.println("jongo " + jongo);
        ArrayList<Products> products = new ArrayList<Products>();

        org.jongo.MongoCursor<Products> productList = null;

        org.jongo.MongoCollection allProduct;
        allProduct = jongo.getCollection("product");

        productList = allProduct.find().as(Products.class);

        Iterator<Products> prd_iter = productList.iterator();
        while (prd_iter.hasNext()) {
            Products prd = prd_iter.next();
            products.add(prd);
        }
        productList.close();
        return products;

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.accenture.dao.MongoDBClient#createClient(com.accenture.model.Client)
     */
    public Client createClient(Client newClient) throws Exception {

        jongo = builder.getnJongoConnection();
        org.jongo.MongoCollection allClient = jongo.getCollection("client");

        allClient.save(newClient);

        return newClient;
    }

    public Products createProduct(Products newProduct) throws Exception {

        jongo = builder.getnJongoConnection();
        org.jongo.MongoCollection allProduct = jongo.getCollection("product");

        allProduct.save(newProduct);

        return newProduct;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.accenture.dao.MongoDBClient#updateClient(com.accenture.model.Client)
     */
    public Client updateClient(Client clientData) throws Exception {

        jongo = builder.getnJongoConnection();
        org.jongo.MongoCollection allclient = jongo.getCollection("client");

        allclient.update("{clientId:#}", clientData.getClientId()).with(clientData);

        return clientData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.accenture.dao.MongoDBClient#deleteClient(java.lang.String)
     */
    public Boolean deleteClient(String clientId) throws Exception {

        jongo = builder.getnJongoConnection();
        org.jongo.MongoCollection allClient;
        allClient = jongo.getCollection("client");

        allClient.remove("{clientId:#}", clientId);

        return true;
    }

    @Override
    public void setBuilder(MongoDBConnectionBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<Client> retrieveClient(String clientId) throws IOException, Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Products> retrieveProduct(String productId) throws Exception {
        jongo = builder.getnJongoConnection();

        System.out.println("jongo " + jongo);
        ArrayList<Products> products = new ArrayList<Products>();

        org.jongo.MongoCursor<Products> productList = null;

        org.jongo.MongoCollection allClient;
        allClient = jongo.getCollection("product");

        if (productId != null) {
            productList = allClient.find("{id:#}", productId).as(Products.class);
        } else {
            productList = allClient.find().as(Products.class);
        }

        Iterator<Products> product_iter = productList.iterator();
        while (product_iter.hasNext()) {
            Products product = product_iter.next();
            products.add(product);
        }
        productList.close();
        System.out.println("products: " + products);
        return products;
    }

}
