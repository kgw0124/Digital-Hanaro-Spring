package com.hana.app.repository;

import com.hana.app.data.dto.One2oneDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface One2oneRepository {
    void save(One2oneDto one2oneDto);
}
