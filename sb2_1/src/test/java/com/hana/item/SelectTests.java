package com.hana.item;

import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import com.hana.app.service.ItemService;
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
    ItemService itemService;
    @Test
    void contextLoads(){
        try {
            itemService.get(1);
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
