package com.hana.controller;

import com.hana.app.data.dto.NoticeDto;
import com.hana.app.service.CommunityService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community")
@Slf4j
public class CommuntiyController {

    final CommunityService communityService;
    String dir = "community/";
    @RequestMapping("/notice")
    public String notice(Model model){
        List<NoticeDto> list = null;
        list = communityService.get();

        model.addAttribute("notices", list);
        model.addAttribute("center", dir + "notice");
        return "index";
    }

    @RequestMapping("/notice/search")
    @ResponseBody
    public List<NoticeDto> search(@RequestParam("option") String option, @RequestParam("input") String input){
        List<NoticeDto> list = null;
        list = communityService.search(option, input);
        return list;
    }

    @RequestMapping("/notice/order")
    @ResponseBody
    public List<NoticeDto> order(@RequestParam("option") String option){
        List<NoticeDto> list = null;
        list = communityService.order(option);
        return list;
    }

    @RequestMapping("/notice/page")
    @ResponseBody
    public List<NoticeDto> page(@RequestParam("option") String option){
        List<NoticeDto> list = null;
        list = communityService.page(option);
        return list;
    }

    @RequestMapping("/notice/save")
    public String save(NoticeDto noticeDto, HttpSession httpSession){
        noticeDto.setNoticeMemberId((String) httpSession.getAttribute("id"));
        communityService.save(noticeDto);
        return "redirect:/admin/notice";
    }

    @RequestMapping("/notice/edit")
    public String edit(Model model, @RequestParam("id") int id){
        NoticeDto result = communityService.findById(id);

        model.addAttribute("notice", result);
        return "admin/noticeEdit";
    }

    @RequestMapping("/notice/editImpl")
    public String edit(NoticeDto noticeDto, HttpSession httpSession){
        noticeDto.setNoticeMemberId((String) httpSession.getAttribute("id"));
        communityService.edit(noticeDto);
        return "redirect:/admin/notice";
    }

    @RequestMapping("/noticeDetail")
    public String noticeDetail(Model model, @RequestParam("id") int id){
        NoticeDto result = communityService.findById(id);

        model.addAttribute("notice", result);
        model.addAttribute("center", dir + "noticeDetail");
        return "index";
    }
}
