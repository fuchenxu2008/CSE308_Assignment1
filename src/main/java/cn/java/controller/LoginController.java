/**
 * Project Name:CSE308_Assignment1
 * File Name:LoginController.java
 * Package Name:cn.java.controller
 * Date:2019年5月16日上午5:42:38
 * Copyright (c) 2019, All Rights Reserved.
 *
*/

package cn.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.java.service.ClientService;

/**
 * Description: <br/>
 * Date: 2019年5月16日 上午5:42:38 <br/>
 * 
 * @author asus
 * @version
 * @see
 */
@Controller
public class LoginController {
    @Autowired
    ClientService clientService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        JSONObject client = clientService.login(username, password);
        if (client != null) {
            request.getSession().setAttribute("client", client);
            return "/welcome";
        } else {
            request.setAttribute("errorMessage", "Authentication  Failed");
            return "/login";
        }
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "/welcome";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("client");
        return "/welcome";
    }

}
