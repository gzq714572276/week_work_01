package com.zjw.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zjw.Email;
import com.zjw.User;
import com.zjw.service.IEmailService;
import com.zjw.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private IUserService userService;
    @Reference
    private IEmailService emailService;

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/getEmail")
    @ResponseBody
    public boolean getEmail(@RequestParam String addressee, HttpServletRequest request){
        System.out.println(addressee);

        Email email = emailService.getEmailCode(addressee);
        request.getSession().setAttribute("emailCode",email.getContent());
        return true;
    }
    @RequestMapping("/register")
    public String register(User user, HttpServletRequest request, Model model){
        System.out.println(user);
        String emailCode = (String)request.getSession().getAttribute("emailCode");
        if(emailCode.equals(user.getCode())){
            userService.insert(user);
            return "index";
        }
        model.addAttribute("msg","注册失败");
        return "register";
    }
    @RequestMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password,Model model){
        System.out.println(name +"---->"+ password);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("password",password);
        List<User> users = userService.queryBy(map);
        if (users != null){
            return "ok";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "index";
    }
    @RequestMapping("/toForgotPwd")
    public String toForgotPwd(){
        return "forgotPwd";
    }
    @RequestMapping("/forgotPwd")
    public String forgotPwd(@RequestParam String name,Model model){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name",name);
        List<User> users = userService.queryBy(map);
        if(users == null){
            model.addAttribute("msg","该用户不存在");
            return "redirect:/user/toForgotPwd";
        }
        emailService.getEmailToPwd(users.get(0).getEmail(),name);
        return "index";
    }
    @RequestMapping("/toResetPsw")
    public String toResetPsw(@RequestParam String name,Model model){
        System.out.println(name);
        model.addAttribute("name",name);
        return "resetPsw";
    }
    @RequestMapping("/resetPwd")
    public String resetPwd(@RequestParam String name,@RequestParam String password){
        System.out.println(name +"---->"+ password);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name",name);
        List<User> users = userService.queryBy(map);
        User user = users.get(0);
        user.setPassword(password);
        userService.resetPwd(user);
        return "index";
    }


}
