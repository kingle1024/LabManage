package com.gworld.manage.comment.service;

import com.gworld.manage.comment.entity.Comment;
import com.gworld.manage.comment.model.CommentDto;
import com.gworld.manage.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;

    @Override
    public List<CommentDto> list(Long boardNo, String typeCode) {
        List<Comment> optionalComments = commentRepository.findAllByBoardNoAndTypeCode(boardNo, typeCode);
        return CommentDto.of(optionalComments);
    }
}
