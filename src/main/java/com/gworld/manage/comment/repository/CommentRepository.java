package com.gworld.manage.comment.repository;

import com.gworld.manage.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByBoardNoAndTypeCode(long boardNo, String typeCode);
}
