package com.hana.app.repository;

import com.hana.app.data.dto.AdminDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminRepository {
    AdminDto findById(String id);
}
