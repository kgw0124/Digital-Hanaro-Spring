package com.hana.addr;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.service.AddrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class InsertTests {
    @Autowired
    AddrService addrService;
    @Test
    void contextLoads(){
        AddrDto addrDto = AddrDto.builder().addrName("test1").addrDetail("test1").custId("id01").build();
        try {
            addrService.add(addrDto);
            log.info("-----OK-----");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof SQLException){
                log.info("-----System Trouble EX001-----");
            }else if(e instanceof DuplicateKeyException){
                log.info("-----System Trouble EX002-----");
            }else{
                log.info("-----System Trouble EX003-----");
            }
            throw new RuntimeException(e);
        }
    }
}
