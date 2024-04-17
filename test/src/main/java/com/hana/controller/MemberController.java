package com.hana.controller;

import com.hana.app.data.dto.MemberDto;
import com.hana.app.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class MemberController {
    String dir = "member/";

    final MemberService memberService;

    @RequestMapping("/idFind")
    public String idFind(){
        return "member/idFind";
    }

    @RequestMapping("/idFindImpl")
    @ResponseBody
    public String idFindImpl(@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail){
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberName(userName);
        memberDto.setMemberEmail(userEmail);
        MemberDto result = memberService.findByNameAndEmail(memberDto);

        String prompt = "회원님의 암호는 " + result.getMemberId() + " 입니다.";
        String btn = "<div><input type=\"image\" src=\"../img/member/btn_close.gif\" onclick=\"window.close()\"></div>";
        return prompt + btn;
    }

    @RequestMapping("/passwordFind")
    public String passwordFind(){
        return "member/passwordFind";
    }

    @RequestMapping("/passwordFindImpl")
    @ResponseBody
    public String passwordFindImpl(@RequestParam("userID") String userID, @RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail){
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(userID);
        memberDto.setMemberName(userName);
        memberDto.setMemberEmail(userEmail);
        MemberDto result = memberService.findByIdAndNameAndEmail(memberDto);

        String prompt = "회원님의 암호는 " + result.getMemberPw() + " 입니다.";
        String btn = "<div><input type=\"image\" src=\"../img/member/btn_close.gif\" onclick=\"window.close()\"></div>";
        return prompt + btn;
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", dir + "login");
        return "index";
    }

    @RequestMapping("/loginImpl")
    @ResponseBody
    public String loginImpl(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession httpSession){
        MemberDto result = memberService.findById(id);
        if(result == null){
            return "1"; // 존재하지 않은 id
        }
        if(!result.getMemberPw().equals(pw)){
            return "2"; // 틀린 pw
        }

        httpSession.setAttribute("id", id); // session에 정보 저장
        return "0"; // 로그인 성공
    }

    @RequestMapping("/join")
    public String join(Model model){
        model.addAttribute("center", dir + "join");
        return "index";
    }

    @RequestMapping("/joinImpl")
    public String joinImpl(MemberDto memberDto){
        memberService.save(memberDto);
        return "redirect:/";
    }

    @RequestMapping("/checkId")
    @ResponseBody
    public String checkId(@RequestParam("id") String id){
        MemberDto result = memberService.findById(id);
        if(result == null){
            return "1";
        }
        return "0"; // 중복 id
    }
}
