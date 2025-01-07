package com.wyy.demoshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;

@Controller
public class IndexController {

    @RequestMapping({"/index","/"})
    public String toIndex (Model model) {
        model.addAttribute("msg","hello shiro");
        return "index";
    }

    // 处理添加用户的请求
    @GetMapping("/user/add")
    public String addUser() {
        return "user/add";  // 返回addUser.html页面
    }

    // 处理更新用户的请求
    @GetMapping("/user/update")
    public String updateUser() {
        return "/user/update";  // 返回updateUser.html页面
    }
    @RequestMapping("/tologin")
    public String tologin () {

        return "login";
    }

    @RequestMapping("/login")
    public String login (String username, String password,Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名1错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
