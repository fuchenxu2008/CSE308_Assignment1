package com.accenture.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.struts2.interceptor.ServletRequestAware;

public class LoadPrice implements ServletRequestAware {

    HttpServletRequest request;

    private String errorMessage;

    public String getProducts() {
        try {
            String response = sendHttpGetRequest("http://localhost:8081/OrchestrationAPI/products/");
            System.out.println(response);
            if (response.length() == 2) {
                setErrorMessage("No products returned");
                return null;
            } else {
                System.out.println("Response " + response);
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            setErrorMessage("Error Occured");
            return null;
        }

    }

    public String getProduct(String id) {
        try {
            String response = sendHttpGetRequest("http://localhost:8081/OrchestrationAPI/products/" + id);
            System.out.println(response);
            if (response.length() == 2) {
                setErrorMessage("No products returned");
                return null;
            } else {
                System.out.println("Response " + response);
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            setErrorMessage("Error Occured");
            return null;
        }

    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getServletRequest() {
        return this.request;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String sendHttpGetRequest(String url) throws IllegalStateException, IOException, Exception {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader(

                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();

    }
}
