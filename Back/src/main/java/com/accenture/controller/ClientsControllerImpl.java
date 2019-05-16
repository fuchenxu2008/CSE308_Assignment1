package com.accenture.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.model.Client;
import com.accenture.util.ClientMongoDBAccess;
import com.google.gson.Gson;

@Controller
public class ClientsControllerImpl extends AbstractApiController implements ClientsController {
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
    @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = "Application/json")
    public @ResponseBody ResponseEntity<String> retrieveAllClients(HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws Exception {
        // Retrieve the data from the MongoDB
        String jsonResponseString = clientMongoDBAccess.retrieveAllClients();

        // Return
        return new ResponseEntity<String>(jsonResponseString, HttpStatus.OK);

    }

    /**
     * Retrieve a single client
     * 
     * @throws Exception
     */
    @RequestMapping(value = "/clients/{cleintShortName}/{secretKey}", method = RequestMethod.GET, produces = "Application/json")
    public ResponseEntity<String> retrieveSingleClient(@PathVariable("cleintShortName") String clientShortName,
            @PathVariable("secretKey") String secretKey, HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws Exception {
        System.out.println(clientShortName + " - " + secretKey);
        // Retrieve the data from the MongoDB
        String jsonResponseString = clientMongoDBAccess.retrieveSingleClient(clientShortName, secretKey);

        // Return
        return new ResponseEntity<String>(jsonResponseString, HttpStatus.OK);

    }

    /**
     * Create a single client
     * 
     * @throws Exception
     */
    @RequestMapping(value = "/clients", method = RequestMethod.POST, produces = "Application/json")
    // public ResponseEntity<String> createClient(@RequestParam Map<String,
    // String> requestData,
    public ResponseEntity<String> createClient(@RequestBody Client client, HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws Exception {
        // Parse the request data
        // BufferedReader reader = theHttpServletRequest.getReader();
        // Gson gson = new Gson();
        // Client newClient = gson.fromJson(reader, Client.class);
        // newClient.setClientId(newClient.getShort_name());

        // Retrieve the data from the MongoDB
        String jsonResponseString = clientMongoDBAccess.createClient(client);
        // String jsonResponseString =
        // clientMongoDBAccess.createClient(newClient);

        // Return
        return new ResponseEntity<String>(jsonResponseString, HttpStatus.OK);

    }

    /**
     * Update a single client
     * 
     * @throws Exception
     */
    @RequestMapping(value = "/clients", method = RequestMethod.PUT, produces = "Application/json")
    public ResponseEntity<String> updateClient(@RequestParam Map<String, String> requestData,
            HttpServletRequest theHttpServletRequest, HttpServletResponse theHttpServletResponse) throws Exception {
        // Parse the request data
        BufferedReader reader = theHttpServletRequest.getReader();
        Gson gson = new Gson();
        Client clientData = gson.fromJson(reader, Client.class);
        clientData.setClientId(clientData.getShort_name());

        // Retrieve the data from the MongoDB
        String jsonResponseString = clientMongoDBAccess.updateClient(clientData);

        // Return
        return new ResponseEntity<String>(jsonResponseString, HttpStatus.OK);

    }

    /**
     * Delete a single client
     * 
     * @throws Exception
     */
    @RequestMapping(value = "/clients/{cleintShortName}", method = RequestMethod.DELETE, produces = "Application/json")
    public ResponseEntity<String> deleteClient(@PathVariable("cleintShortName") String cleintShortName,
            HttpServletRequest theHttpServletRequest, HttpServletResponse theHttpServletResponse) throws Exception {
        // Retrieve the data from the MongoDB
        String jsonResponseString = clientMongoDBAccess.deleteClient(cleintShortName);

        // Return
        return new ResponseEntity<String>(jsonResponseString, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> retrieveSingleClient(String clientId, HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws IOException, Exception {
        // TODO Auto-generated method stub
        return null;
    }

}