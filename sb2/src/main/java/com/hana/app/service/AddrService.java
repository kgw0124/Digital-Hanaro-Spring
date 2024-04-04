package com.hana.app.service;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.AddrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddrService implements HanaService<Integer, AddrDto> {

    final AddrRepository addrRepository;

    @Override
    public int add(AddrDto addrDto) throws Exception {
        return addrRepository.insert(addrDto);
    }

    @Override
    public int del(Integer i) throws Exception {
        return addrRepository.delete(i);
    }

    @Override
    public int modify(AddrDto addrDto) throws Exception {
        return addrRepository.update(addrDto);
    }

    @Override
    public AddrDto get(Integer i) throws Exception {
        return addrRepository.selectOne(i);
    }

    @Override
    public List<AddrDto> get() throws Exception {
        return addrRepository.select();
    }
}
