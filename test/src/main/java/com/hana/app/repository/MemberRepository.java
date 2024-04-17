package com.hana.app.repository;

import com.hana.app.data.dto.MemberDto;
import com.hana.app.data.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberRepository {
    MemberDto findById(String id);
    MemberDto findByNameAndEmail(MemberDto memberDto);
    MemberDto findByIdAndNameAndEmail(MemberDto memberDto);
    List<MemberDto> selectAll();
    void save(MemberDto memberDto);
}