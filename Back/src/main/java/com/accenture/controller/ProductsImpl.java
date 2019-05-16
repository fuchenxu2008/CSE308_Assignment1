package com.accenture.controller;

import java.io.BufferedReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.model.Products;
import com.accenture.util.ClientMongoDBAccess;
import com.google.gson.Gson;

@Controller
public class ProductsImpl extends AbstractApiController {
    @Autowired
    ClientMongoDBAccess clientMongoDBAccess;

    @Value("${accenture-paas-api.project.deployURL}")
    private String deployURL;

    @Value("${accenture-paas-api.project.awsDeleteInstanceURL}")
    private String awsDeleteInstanceURL;

    @Value("${accenture-paas-api.project.createKeyPairURL}")
    private String createKeyPairURL;

    /**
     * Retrieve all clients from MongoDB
     * 
     * @throws Exception
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "Application/json")
    public @ResponseBody ResponseEntity<String> retrieveAllClients(HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws Exception {
        // Retrieve the data from the MongoDB
        String jsonResponseString = clientMongoDBAccess.retrieveAllProducts();

        // Return
        return new ResponseEntity<String>(jsonResponseString, HttpStatus.OK);

    }

    /**
     * Create a single client
     * 
     * @throws Exception
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = "Application/json")
    public ResponseEntity<String> createClient(@RequestParam Map<String, String> requestData,
            HttpServletRequest theHttpServletRequest, HttpServletResponse theHttpServletResponse) throws Exception {
        // Parse the request data
        BufferedReader reader = theHttpServletRequest.getReader();
        Gson gson = new Gson();
        Products newProducts = gson.fromJson(reader, Products.class);

        // Retrieve the data from the MongoDB
        String jsonResponseString = clientMongoDBAccess.createProduct(newProducts);

        // Return
        return new ResponseEntity<String>(jsonResponseString, HttpStatus.OK);

    }

    /**
     * Retrieve a single client
     * 
     * @throws Exception
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = "Application/json")
    public ResponseEntity<String> retrieveSingleClient(@PathVariable("id") String id,
            HttpServletRequest theHttpServletRequest, HttpServletResponse theHttpServletResponse) throws Exception {
        // Retrieve the data from the MongoDB
        String jsonResponseString = clientMongoDBAccess.retrieveSingleProduct(id);
        // Return
        return new ResponseEntity<String>(jsonResponseString, HttpStatus.OK);

    }

}