package com.hana.app.service;

import com.hana.app.data.dto.NoticeDto;
import com.hana.app.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunityService {
    final CommunityRepository communityRepository;

    public List<NoticeDto> get() {
        return communityRepository.selectAll();
    }

    public List<NoticeDto> search(String option, String input) {
        switch (option){
            case "title":
                return communityRepository.searchByTitle(input);
            case "content":
                return communityRepository.searchByContent(input);
        }
        return null;
    }

    public NoticeDto findById(int id) {
        return communityRepository.findById(id);
    }

    public void save(NoticeDto noticeDto) {
        communityRepository.save(noticeDto);
    }
}
