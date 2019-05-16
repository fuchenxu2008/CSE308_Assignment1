/**
 * Project Name:CSE308_Assignment1
 * File Name:UserService.java
 * Package Name:cn.java.service
 * Date:2019年5月16日上午5:43:50
 * Copyright (c) 2019, All Rights Reserved.
 *
*/

package cn.java.service;

import org.json.simple.JSONObject;

/**
 * Description: <br/>
 * Date: 2019年5月16日 上午5:43:50 <br/>
 * 
 * @author asus
 * @version
 * @see
 */
public interface ClientService {
    JSONObject login(String username, String password);
}
