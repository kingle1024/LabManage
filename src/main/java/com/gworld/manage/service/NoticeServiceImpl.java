package com.gworld.manage.service;

import com.gworld.manage.model.Board;
import com.gworld.manage.model.BoardDto;
import com.gworld.manage.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {

    private final BoardRepository boardRepository;
    @Override
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Override
    public BoardDto detail(long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);

        if(optionalBoard.isEmpty()){
            return null;
        }
        Board board = optionalBoard.get();

        return BoardDto.of(board);
    }
}
