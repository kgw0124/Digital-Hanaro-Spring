package com.hana.app.service;

import com.hana.app.data.dto.MemberDto;
import com.hana.app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
