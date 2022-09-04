package com.gworld.manage.service;

import com.gworld.manage.model.Board;
import com.gworld.manage.model.BoardDto;
import com.gworld.manage.model.ServiceResult;
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

    @Override
    public ServiceResult delete(Long id) {
        ServiceResult result = new ServiceResult();

        Optional<Board> optionalBoard = boardRepository.findById(id);
        if(optionalBoard.isEmpty()){
            result.setResult(false);
            result.setMessage("게시글 정보가 존재하지 않습니다.");
            return result;
        }

        Board board = optionalBoard.get();
        board.setDeleteYn(true);
        boardRepository.save(board);

        result.setResult(true);
        result.setMessage("");
        return result;
    }
}
