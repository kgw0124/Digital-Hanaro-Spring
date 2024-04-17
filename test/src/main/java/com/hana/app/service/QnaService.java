package com.hana.app.service;

import com.hana.app.data.dto.NoticeDto;
import com.hana.app.data.dto.QnaDto;
import com.hana.app.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {
    final QnaRepository qnaRepository;

    public List<QnaDto> get() {
        return qnaRepository.selectAll();
    }

    public List<QnaDto> search(String option, String input) {
        switch (option){
            case "title":
                return qnaRepository.searchByTitle(input);
            case "content":
                return qnaRepository.searchByContent(input);
            case "writer":
                return qnaRepository.searchByWriter(input);
        }
        return null;
    }

    public QnaDto findById(String id) {
        return qnaRepository.findById(id);
    }

}
