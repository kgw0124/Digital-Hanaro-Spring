package com.hana.controller;

// !! ajax를 통해 호출되면 controller 대신 restcontroller 사용
import com.hana.app.dto.Chart2Dto;
import com.hana.app.dto.CustDto;
import com.hana.app.dto.ShopDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }

    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("id") String id){
        String result = "1";
        if(id.equals("qqq")){ // 이미 qqq라는 id는 DB에 존재한다고 가정
            result = "0";
        }
        return result;
    }

    @RequestMapping("/getdata")
    public Object getdata(){
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        return list;
    }

    @RequestMapping("/geo/getdata")
    public Object geo_getdata(){
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100, "순대국", "a.jpg", 37.5547611,127.0654625));
        list.add(new ShopDto(101, "파스타", "b.jpg", 37.5647611,127.0754625));
        list.add(new ShopDto(102, "햄버거", "c.jpg", 37.5747611,127.0854625));
        return list;
    }

    @RequestMapping("/chart2")
    public Object chart2(){
        JSONArray ja = new JSONArray();

        List<Chart2Dto> list = new ArrayList<>();
        // [{"name":"S001","m1":10,....},{},{},{}]
        list.add(new Chart2Dto("S001",10,20,30,20,10,15));
        list.add(new Chart2Dto("S002",13,30,60,10,10,25));
        list.add(new Chart2Dto("S003",11,10,70,80,15,35));
        list.add(new Chart2Dto("S004",18,20,20,90,22,45));

        list.stream().forEach(c->{
            JSONObject jo = new JSONObject();
            // [{name, data:[]}]
            jo.put("name",c.getName());
            jo.put("data",c.getM());
            ja.add(jo);
        });

        /*
        for(Chart2Dto c:list){
            JSONObject jo = new JSONObject();
            // [{name, data:[]}]
            jo.put("name",c.getName());
            jo.put("data",c.getM());
            ja.add(jo);
        }
         */
        return ja;
    }
}
