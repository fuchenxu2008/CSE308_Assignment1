/**
 * 
 */
package com.accenture.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.accenture.model.Client;
import com.accenture.util.exception.AbstractException;
import com.accenture.util.exception.AbstractRuntimeException;
import com.accenture.util.exception.ItemCreateException;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author
 *
 */
public interface ClientsController {

    // void commonOptions(HttpServletResponse theHttpServletResponse);

    // Clients

    ResponseEntity<String> retrieveAllClients(HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws IOException, ItemCreateException, Exception;

    ResponseEntity<String> retrieveSingleClient(String clientId, HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws IOException, Exception;

    ResponseEntity<String> createClient(Client client, HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws AbstractException, AbstractRuntimeException,
            AbstractRuntimeException, IOException, ItemCreateException, Exception;
    // ResponseEntity<String> createClient(Map<String, String> requestData,
    // Client client,
    // HttpServletRequest theHttpServletRequest, HttpServletResponse
    // theHttpServletResponse)
    // throws AbstractException, AbstractRuntimeException,
    // AbstractRuntimeException, IOException,
    // ItemCreateException, Exception;

    ResponseEntity<String> updateClient(Map<String, String> requestData, HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws JsonProcessingException, IOException, Exception;

    ResponseEntity<String> deleteClient(String clientId, HttpServletRequest theHttpServletRequest,
            HttpServletResponse theHttpServletResponse) throws JsonProcessingException, IOException, Exception;

}
