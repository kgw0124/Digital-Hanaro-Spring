package com.hana.app.service;

import com.hana.app.data.dto.MemberDto;
import com.hana.app.data.dto.NoticeDto;
import com.hana.app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    final MemberRepository memberRepository;

    public MemberDto findById(String id) {
        return memberRepository.findById(id);
    }

    public MemberDto findByNameAndEmail(MemberDto memberDto) {
        return memberRepository.findByNameAndEmail(memberDto);
    }

    public MemberDto findByIdAndNameAndEmail(MemberDto memberDto) { return memberRepository.findByIdAndNameAndEmail(memberDto); }

    public void save(MemberDto memberDto) {
        memberRepository.save(memberDto);
    }

    public List<MemberDto> get() {
        return memberRepository.selectAll();
    }

    public List<MemberDto> search(String option, String input) {
        switch (option){
            case "all":
                return memberRepository.search(input);
            case "id":
                return memberRepository.searchById(input);
            case "name":
                return memberRepository.searchByName(input);
            case "email":
                return memberRepository.searchByEmail(input);
        }
        return null;
    }

    public List<MemberDto> order(String option) {
        switch (option){
            case "id_asc":
                return memberRepository.orderById();
            case "id_desc":
                return memberRepository.orderByIdDesc();
            case "join_date_asc":
                return memberRepository.orderByJoinDate();
            case "join_date_desc":
                return memberRepository.orderByJoinDateDesc();
        }
        return null;
    }

    public List<MemberDto> top(String option) {
        switch (option){
            case "all":
                return memberRepository.selectAll();
            case "5":
                return memberRepository.select5();
            case "10":
                return memberRepository.select10();
        }
        return null;
    }
}
