/**
 * Project Name:CSE308_Assignment1
 * File Name:RecommendationController.java
 * Package Name:cn.java.controller
 * Date:2019年5月16日上午5:42:56
 * Copyright (c) 2019, All Rights Reserved.
 *
*/

package cn.java.controller;
/**
 * Description:	   <br/>
 * Date:     2019年5月16日 上午5:42:56 <br/>
 * @author   asus
 * @version  
 * @see 	 
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.java.service.ProductService;

@Controller
public class RecommendationController {
    @Autowired
    ProductService productService;

    @RequestMapping("/recommendation")
    public String recommendation(Integer number, HttpServletRequest request) {
        request.setAttribute("productList", productService.getProductList(number));
        request.setAttribute("recentProductList", productService.getRecentProductList());
        request.setAttribute("number", number);
        return "/baseLayout2";
    }
}
