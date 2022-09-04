package com.gworld.manage.comment.service;

import com.gworld.manage.comment.entity.Comment;
import com.gworld.manage.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> list(Long boardNo, String typeCode) {
        Optional<List<Comment>> optionalComments = commentRepository.findAllByBoardNoAndTypeCode(boardNo, typeCode);

        if(optionalComments.isEmpty()){
            return null;
        }
        return optionalComments.get();
    }
}
