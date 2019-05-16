package com.accenture.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
// import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.HttpClients;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletRequestAware {

    private static final long serialVersionUID = 1L;

    HttpServletRequest request;

    private String errorMessage;

    private String username;

    private String password;

    public String welcome() {
        return "welcome";
    }

    // public String login() {

    //     try {
    //         String response = sendHttpGetRequest(
    //                 "http://localhost:8080/OrchestrationAPI/clients/" + username + "/" + password);
    //         System.out.println(response);
    //         JSONArray jsonArray = (JSONArray) new JSONParser().parse(response);
    //         if (jsonArray.size() == 1) {
    //             JSONObject client = (JSONObject) jsonArray.get(0);
    //             if (username.equals((String) client.get("clientId"))
    //                     && password.equals((String) client.get("secretKey"))) {

    //                 request.getSession().setAttribute("client", client);
    //                 return "loginpass";
    //             }
    //         }
    //         // if (username == null || username.length() == 0 || password ==
    //         // null || password.length() == 0) {
    //         // request.getSession();
    //         return "loginfail";
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         setErrorMessage("Authentication	 Failed");
    //         return "loginfail";
    //     }

    // }

    public String logout() {
        return "welcome";

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}
