/**
 * Project Name:CSE308_Assignment1
 * File Name:ClientServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2019年5月16日上午5:59:06
 * Copyright (c) 2019, All Rights Reserved.
 *
*/

package cn.java.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import cn.java.service.ClientService;

/**
 * Description: <br/>
 * Date: 2019年5月16日 上午5:59:06 <br/>
 * 
 * @author asus
 * @version
 * @see
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public JSONObject login(String username, String password) {
        try {
            String response = sendHttpGetRequest(
                    "http://localhost:8080/OrchestrationAPI/clients/" + username + "/" + password);
            System.out.println(response);
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(response);
            if (jsonArray.size() == 1) {
                JSONObject client = (JSONObject) jsonArray.get(0);
                if (username.equals((String) client.get("clientId"))
                        && password.equals((String) client.get("secretKey"))) {

                    return client;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String sendHttpGetRequest(String url) throws IllegalStateException, IOException {

        // DefaultHttpClient client = new DefaultHttpClient();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        client.close();
        return result.toString();

    }

}
