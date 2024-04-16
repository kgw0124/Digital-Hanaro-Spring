package com.hana.cust;

import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
public class InsertTests {
    CustService custService;
    @Test
    void contextLoads(){
        CustDto custDto = CustDto.builder().id("id03").pwd("pwd03").name("이말숙").build();
        try {
            custService.add(custDto);
            log.info("-----OK-----");
        } catch (Exception e) {
            if(e instanceof SQLException){
                log.info("-----System Trouble EX001-----");
            }else if(e instanceof DuplicateKeyException){
                log.info("-----System Trouble EX002-----");
            }else{
                log.info("-----ID Duplicated EX003-----");
            }
            throw new RuntimeException(e);
        }
    }
}
