package com.hana.cust;

import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class SelectTests {
    @Autowired
    CustService custService;
    @Test
    void contextLoads(){
        List<CustDto> list = new ArrayList<>();
        try {
            list = custService.get();
            for(CustDto c: list){
                log.info(c.toString());
            }
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
