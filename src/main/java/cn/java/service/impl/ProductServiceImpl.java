/**
 * Project Name:CSE308_Assignment1
 * File Name:ProductServiceImpl.java
 * Package Name:cn.java.service.impl
 * Date:2019年5月16日上午7:06:49
 * Copyright (c) 2019, All Rights Reserved.
 *
*/

package cn.java.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.actions.LoadPrice;
import com.accenture.actions.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.java.service.ProductService;

/**
 * Description: <br/>
 * Date: 2019年5月16日 上午7:06:49 <br/>
 * 
 * @author asus
 * @version
 * @see
 */
@Service
public class ProductServiceImpl implements ProductService {
    LoadPrice load = new LoadPrice();

    @Override
    public List<Product> getProductList(Integer productType) {
        if (productType == null) {
            productType = 2;
        }
        List<Product> productList = new ArrayList<Product>();
        List<String> nameList = new ArrayList<String>();
        List<String> priceList = new ArrayList<String>();

        try {
            File file = new File("D:/Program Files/apache-tomcat-9.0.10/webapps/CSE308_Assignment1/resources/images"
                    + "/" + productType + "/" + "productDesc.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                nameList.add(line);

            }
            fileReader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        try {
            File file = new File("D:/Program Files/apache-tomcat-9.0.10/webapps/CSE308_Assignment1/resources/images"
                    + "/" + productType + "/" + "/" + "pricelist.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                priceList.add(line);

            }
            fileReader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        int count = Integer.min(nameList.size(), priceList.size());
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setName(nameList.get(i));
            product.setPrice(priceList.get(i));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> getRecentProductList() {
        List<Product> productList = new ArrayList<Product>();
        String jsonObject = load.getProducts();

        final ObjectMapper mapper = new ObjectMapper();
        try {
            Product[] resp = mapper.readValue(jsonObject, Product[].class);
            for (Product a : resp) {
                productList.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

}
