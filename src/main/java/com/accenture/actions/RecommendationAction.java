package com.accenture.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class RecommendationAction extends ActionSupport implements ServletRequestAware {

    private static final long serialVersionUID = 1L;

    HttpServletRequest request;

    private String id;

    private String name;

    private String price;

    private Integer number;

    private List<String> priceList;

    private List<String> imageUrlList;

    private List<String> imageDescList;

    private List<String> starImageUrlList;

    private ArrayList<Product> recentProductList = new ArrayList<Product>();

    private ArrayList<Product> productList = new ArrayList<Product>();

    LoadPrice load = new LoadPrice();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String welcome() {
        return "welcome";
    }

    public HttpServletRequest getServletRequest() {
        return this.request;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Product> getRecentProductList() {
        return recentProductList;
    }

    public void setRecentProductList(ArrayList<Product> recentProductList) {
        this.recentProductList = recentProductList;
    }

    public String detail() {
        Product product = getProduct(id);
        System.out.println(product);
        request.setAttribute("product", product);
        return "detail";
    };

    public String recommendation0() {
        setProductNameAndPrice(number);
        request.setAttribute("number", number);
        getProducts();
        return "rec0";
    }

    public String recommendation1() {
        setProductImageAndDescription("1");
        return "rec1";
    }

    public String recommendation2() {
        setProductImageAndDescription("2");
        getProducts();
        return "rec2";
    }

    public String recommendation3() {
        setProductImageAndDescription("3");
        return "rec3";
    }

    public String recommendation4() {
        setProductImageAndDescription("4");
        return "rec4";
    }

    public String recommendation5() {
        setProductImageAndDescription("5");
        return "rec5";
    }

    public String recommendation6() {
        setProductImageAndDescription("6");
        return "rec6";
    }

    public String recommendation7() {
        setProductImageAndDescription("7");
        return "rec7";
    }

    public void setProductNameAndPrice(Integer productType) {
        if (productType == null) {
            this.number = 2;
            productType = 2;
        }
        imageDescList = new ArrayList<String>();
        priceList = new ArrayList<String>();

        try {
            File file = new File("../webapps/CSE308_Assignment1/resources/images"
                    + "/" + productType + "/" + "productDesc.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                imageDescList.add(line);

            }
            fileReader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        try {
            File file = new File("../webapps/CSE308_Assignment1/resources/images"
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

        int count = Integer.min(imageDescList.size(), priceList.size());
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setName(imageDescList.get(i));
            product.setPrice(priceList.get(i));
            productList.add(product);
        }
    }

    public void setProductImageAndDescription(String productType) {
        imageUrlList = new ArrayList<String>();
        imageDescList = new ArrayList<String>();
        starImageUrlList = new ArrayList<String>();
        priceList = new ArrayList<String>();
        File imageDir = new File("../webapps/CSE308_Assignment1/resources/images"
                + "/" + productType);
        for (File imageFile : imageDir.listFiles()) {
            String imageFileName = imageFile.getName();

            // add this images name to the list we are building up
            if (imageFileName.contains("jpg")) {
                imageUrlList.add(imageFileName);
            }
        }
        try {
            File file = new File("../webapps/CSE308_Assignment1/resources/images"
                    + "/" + productType + "/" + "/" + "productDesc.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                imageDescList.add(line);

            }
            fileReader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        try {
            File file = new File("../webapps/CSE308_Assignment1/resources/images"
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

        File StarImageDir = new File(
                "../webapps/CSE308_Assignment1/resources/images" + "/starInfo");
        for (File imageFile : StarImageDir.listFiles()) {
            String imageFileName = imageFile.getName();
            // add this images name to the list we are building up
            starImageUrlList.add(imageFileName);
        }

    }

    /*
     * Method to load the price list
     */
    public void getProducts() {
        String jsonObject = load.getProducts();

        final ObjectMapper mapper = new ObjectMapper();
        try {
            Product[] resp = mapper.readValue(jsonObject, Product[].class);
            for (Product a : resp) {
                recentProductList.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(String id) {
        String jsonObject = load.getProduct(id);

        final ObjectMapper mapper = new ObjectMapper();
        try {
            Product[] resp = mapper.readValue(jsonObject, Product[].class);
            return resp[0];

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
