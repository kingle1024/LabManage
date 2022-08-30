package com.gworld.manage.service;

import com.gworld.manage.model.Board;
import com.gworld.manage.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    @Override
    public List<Board> list() {
        return boardRepository.findAll();
    }
}
