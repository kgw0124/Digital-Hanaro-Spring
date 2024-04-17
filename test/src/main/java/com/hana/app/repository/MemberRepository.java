package com.hana.app.repository;

import com.hana.app.data.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberRepository {
    MemberDto findById(String id);
    MemberDto findByNameAndEmail(MemberDto memberDto);
    MemberDto findByIdAndNameAndEmail(MemberDto memberDto);
    void save(MemberDto memberDto);
}
