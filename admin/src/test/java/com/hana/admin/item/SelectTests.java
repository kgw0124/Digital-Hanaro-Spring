package com.hana.admin.item;

import com.hana.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class SelectTests {
    @Autowired
    ItemService itemService;
    @Test
    void contextLoads(){
        try {
            itemService.get();
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
