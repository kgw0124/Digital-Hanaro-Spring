package com.hana.app.repository;

import com.hana.app.data.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommunityRepository {
    List<NoticeDto> selectAll();
    List<NoticeDto> searchByTitle(String input);
    List<NoticeDto> searchByContent(String input);
    NoticeDto findById(int id);
    void save(NoticeDto noticeDto);
}
