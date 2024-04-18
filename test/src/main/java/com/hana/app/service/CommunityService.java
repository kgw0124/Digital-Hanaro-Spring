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
            case "all":
                return communityRepository.search(input);
            case "title":
                return communityRepository.searchByTitle(input);
            case "content":
                return communityRepository.searchByContent(input);
            case "memberId":
                return communityRepository.searchByMemberId(input);
        }
        return null;
    }

    public NoticeDto findById(int id) {
        return communityRepository.findById(id);
    }

    public void save(NoticeDto noticeDto) {
        communityRepository.save(noticeDto);
    }

    public void edit(NoticeDto noticeDto) {
        communityRepository.edit(noticeDto);
    }

    public List<NoticeDto> order(String option) {
        switch (option){
            case "id_asc":
                return communityRepository.orderByMemberId();
            case "id_desc":
                return communityRepository.orderByMemberIdDesc();
            case "reg_date_asc":
                return communityRepository.orderByNoticeDate();
            case "reg_date_desc":
                return communityRepository.orderByNoticeDateDesc();
        }
        return null;
    }

    public List<NoticeDto> page(String option) {
        switch (option){
            case "all":
                return communityRepository.selectAll();
            case "5":
                return communityRepository.select5();
            case "10":
                return communityRepository.select10();
        }
        return null;
    }
}
