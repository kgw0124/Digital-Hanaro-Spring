package com.hana.app.service;

import com.hana.app.data.dto.CommentDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements HanaService<Integer, CommentDto> {
    private final CommentRepository commentRepository;

    @Override
    public int add(CommentDto commentDto) throws Exception { // 반환값 int : 추가한 데이터가 있으면 1, 없으면 0
        return commentRepository.insert(commentDto);
    }

    @Override
    public int del(Integer integer) throws Exception {
        return commentRepository.delete(integer);
    }

    @Override
    public int modify(CommentDto commentDto) throws Exception {
        return commentRepository.update(commentDto);
    }

    @Override
    public CommentDto get(Integer integer) throws Exception {
        return commentRepository.selectOne(integer);
    }

    @Override
    public List<CommentDto> get() throws Exception {
        return commentRepository.select();
    }
}
