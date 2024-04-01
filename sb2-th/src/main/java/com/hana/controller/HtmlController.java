package com.hana.controller;

import com.hana.app.dto.CustDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/html")
public class HtmlController {
    String dir = "html/";

    @RequestMapping("/")
    public String main(Model model){
        // webapp/views/html 속에 존재하는 left.jsp와 center.jsp를 호출시키고자 한다.
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }

    @RequestMapping("/html1")
    public String html1(Model model){
        // webapp/views/html 속에 존재하는 left.jsp와 center.jsp를 호출시키고자 한다.
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"html1");
        return "index";
    }

    @RequestMapping("/html2")
    public String html2(Model model){
        // webapp/views/html 속에 존재하는 left.jsp와 center.jsp를 호출시키고자 한다.
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"html2");
        return "index";
    }

    @RequestMapping("/html3")
    public String html3(Model model){
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id02","pwd01","james"));
        list.add(new CustDto("id03","pwd01","james"));
        list.add(new CustDto("id04","pwd01","james"));
        list.add(new CustDto("id05","pwd01","james"));

        // webapp/views/html 속에 존재하는 left.jsp와 center.jsp를 호출시키고자 한다.
        model.addAttribute("custs", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"html3");
        return "index";
    }

    @RequestMapping("/get2")
    public String get(Model model, @RequestParam("id") String id){
        // id값을 DB에 조회한다.
        CustDto c = CustDto.builder().id(id).pwd("pwdpwd").name("james").build();
        // webapp/views/html 속에 존재하는 left.jsp와 center.jsp를 호출시키고자 한다.
        model.addAttribute("cust", c);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"get");
        return "index";
    }
}
