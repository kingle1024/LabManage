package com.gworld.manage.comment.service;

import com.gworld.manage.comment.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    List<Comment> list(Long boardNo, String typeCode);
}
