package com.springsoket.springsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class testContorller {

    @RequestMapping(value="aaa")
    public ModelAndView aaa(){

        return   new ModelAndView("qqq");
    }

    @RequestMapping(value="test")
    public  void test(HttpServletRequest request, HttpServletResponse response){
        System.out.println("111111111");
        try {
             response.getWriter().print("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
