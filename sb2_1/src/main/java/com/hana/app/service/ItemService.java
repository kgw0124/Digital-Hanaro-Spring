package com.hana.app.service;

import com.hana.app.data.dto.ItemDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements HanaService<Integer, ItemDto> {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public int add(ItemDto ItemDto) throws Exception {
        return itemRepository.insert(ItemDto);
    }

    @Override
    public int del(Integer i) throws Exception {
        return itemRepository.delete(i);
    }

    @Override
    public int modify(ItemDto ItemDto) throws Exception {
        return itemRepository.update(ItemDto);
    }

    @Override
    public ItemDto get(Integer i) throws Exception {
        return itemRepository.selectOne(i);
    }

    @Override
    public List<ItemDto> get() throws Exception {
        return itemRepository.select();
    }
}
