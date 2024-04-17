package com.hana.controller;

import com.hana.app.data.dto.AdminDto;
import com.hana.app.data.dto.MemberDto;
import com.hana.app.data.dto.NoticeDto;
import com.hana.app.service.AdminService;
import com.hana.app.service.CommunityService;
import com.hana.app.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    String dir = "admin/";

    final AdminService adminService;
    final MemberService memberService;
    final CommunityService communityService;

    @RequestMapping("/admin")
    public String admin(){
        return dir + "login";
    }

    @RequestMapping("/admin/login")
    @ResponseBody
    public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession httpSession){
        AdminDto result = adminService.findById(id);
        if(result == null){
            return "1"; // 존재하지 않은 id
        }
        if(!result.getMemberPw().equals(pw)){
            return "2"; // 틀린 pw
        }

        httpSession.setAttribute("id", id); // session에 정보 저장
        return "0"; // 로그인 성공
    }

    @RequestMapping("/admin/member")
    public String member(Model model){
        List<MemberDto> list = null;
        list = memberService.get();

        model.addAttribute("count", list.size());
        model.addAttribute("members", list);
        return dir + "member";
    }

    @RequestMapping("/admin/notice")
    public String notice(Model model){
        List<NoticeDto> list = null;
        list = communityService.get();

        model.addAttribute("count", list.size());
        model.addAttribute("notices", list);
        return dir + "notice";
    }

    @RequestMapping("/admin/noticeWrite")
    public String noticeWrite(){
        return dir + "noticeWrite";
    }
}
