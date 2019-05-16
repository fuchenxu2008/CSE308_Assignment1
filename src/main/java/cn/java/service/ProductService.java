/**
 * Project Name:CSE308_Assignment1
 * File Name:ProductService.java
 * Package Name:cn.java.service
 * Date:2019年5月16日上午5:44:00
 * Copyright (c) 2019, All Rights Reserved.
 *
*/

package cn.java.service;
/**
 * Description:	   <br/>
 * Date:     2019年5月16日 上午5:44:00 <br/>
 * @author   asus
 * @version  
 * @see 	 
 */

import java.util.List;

import com.accenture.actions.Product;

public interface ProductService {
    List<Product> getProductList(Integer number);

    List<Product> getRecentProductList();
}
