package com.hana.controller;

import com.hana.app.data.dto.One2oneDto;
import com.hana.app.data.dto.QnaDto;
import com.hana.app.service.One2oneService;
import com.hana.app.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    String dir = "customer/";

    final One2oneService one2oneService;
    final QnaService qnaService;

    @RequestMapping("/one2one")
    public String one2one(Model model){
        model.addAttribute("center", dir + "one2one");
        return "index";
    }

    @RequestMapping("/one2one/save")
    public String save(One2oneDto one2oneDto){
        one2oneService.save(one2oneDto);
        return "redirect:/";
    }

    @RequestMapping("/qna")
    public String qna(Model model){
        List<QnaDto> list = null;
        list = qnaService.get();

        model.addAttribute("questions", list);
        model.addAttribute("center", dir + "qna");
        return "index";
    }

    @RequestMapping("/qna/search")
    @ResponseBody
    public List<QnaDto> search(@RequestParam("option") String option, @RequestParam("input") String input){
        List<QnaDto> list = null;
        list = qnaService.search(option, input);
        return list;
    }

    @RequestMapping("/qnaPw")
    public String qnaPw(){
        return dir + "qnaPw";
    }

    @RequestMapping("/qnaPwImpl")
    @ResponseBody
    public String qnaPwImpl(@RequestParam("id") String id, @RequestParam("pw") String pw){
        QnaDto result = qnaService.findById(id);
        if(result.getQnaPw().equals(pw)){
            return "1";
        }
        return "0";
    }

    @RequestMapping("/qnaDetail")
    public String qnaPwImpl(Model model, @RequestParam("id") String id){
        QnaDto result = qnaService.findById(id);

        model.addAttribute("question", result);
        model.addAttribute("center", dir + "qnaDetail");
        return "index";
    }
}
