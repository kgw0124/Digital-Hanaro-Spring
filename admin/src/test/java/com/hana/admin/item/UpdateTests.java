package com.hana.admin.item;

import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.ItemService;
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
public class UpdateTests {
    @Autowired
    ItemService itemService;
    @Test
    void contextLoads(){
        ItemDto itemDto = ItemDto.builder().itemId(2).itemName("Shirts").itemPrice(10000L).imgName("update.jpg").build();
        try {
            itemService.modify(itemDto);
            log.info("-----OK-----");
        } catch (Exception e) {
            if(e instanceof SQLException){
                log.info("-----System Trouble EX001-----");
            }else if(e instanceof DuplicateKeyException){
                log.info("-----System Trouble EX002-----");
            }else{
                e.printStackTrace();
                log.info("-----ID Duplicated EX003-----");
            }
            throw new RuntimeException(e);
        }
    }
}
