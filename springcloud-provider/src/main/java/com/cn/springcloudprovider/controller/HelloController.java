package com.cn.springcloudprovider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class HelloController {

    //直接使用ModelAndView返回视图数据
    @GetMapping("/abc")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "RestController, 你好");
        mv.setViewName("success");
        return mv;
    }

    //返回的是return的内容
    // @ResponseBody注解，结果success没有经过视图解析器解析，直接变成json字符串返回给浏览器
/*    @GetMapping("/abc")
    public String hello(Model model) {
        model.addAttribute("msg", "Controller,你好");
        return "success";
    }*/

}
