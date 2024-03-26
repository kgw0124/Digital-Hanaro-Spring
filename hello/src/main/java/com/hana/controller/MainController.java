package com.hana.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class MainController {
    @RequestMapping("/")
    public String main(Model m){ // Model의 역할 : 매개체(DB에서 빼온 데이터)를 담아서 JSP로 전달해준다.
        List<String> list = new ArrayList<>();
        list.add("DATA1");
        list.add("DATA2");
        list.add("DATA3");
        m.addAttribute("data", "MyData"); // K-V 형태로 정보를 담는다.
        m.addAttribute("dataList", list);
        return "index";
    }
}
