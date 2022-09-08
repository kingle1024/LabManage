package com.gworld.manage.comment.service;

import com.gworld.manage.comment.entity.Comment;
import com.gworld.manage.comment.model.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    List<CommentDto> list(Long boardNo, String typeCode);
}
