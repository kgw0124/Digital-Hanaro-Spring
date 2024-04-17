package com.hana.app.repository;

import com.hana.app.data.dto.QnaDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QnaRepository {
    List<QnaDto> selectAll();
    List<QnaDto> searchByTitle(String input);
    List<QnaDto> searchByContent(String input);
    List<QnaDto> searchByWriter(String input);
    QnaDto findById(String id);
}
