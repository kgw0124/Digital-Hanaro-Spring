package com.hana.app.service;

import com.hana.app.data.dto.One2oneDto;
import com.hana.app.repository.One2oneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class One2oneService {
    final One2oneRepository one2oneRepository;

    public void save(One2oneDto one2oneDto) {
        one2oneRepository.save(one2oneDto);
    }
}
