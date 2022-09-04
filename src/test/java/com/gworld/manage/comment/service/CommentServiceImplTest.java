package com.gworld.manage.comment.service;

import com.gworld.manage.comment.entity.Comment;
import com.gworld.manage.comment.repository.CommentRepository;
import com.gworld.manage.model.Board;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {
    @InjectMocks
    private CommentServiceImpl commentService;

    @Mock
    private CommentRepository commentRepository;

    @Test
    void listSuccess(){
        // given
        Board board = Board.builder()
                .id(3L)
                .title("title")
                .content("content")
                .typeCode("1001")
                .build();
        Comment c1 = Comment.builder()
                .no(1L)
                .boardNo(100L)
                .comment("comment1")
                .author("author1")
                .typeCode(board.getTypeCode())
                .build();
        Comment c2 = Comment.builder()
                .no(2L)
                .boardNo(100L)
                .comment("comment2")
                .author("author2")
                .typeCode(board.getTypeCode())
                .build();

        List<Comment> givenList = new ArrayList<>();
        givenList.add(c1);
        givenList.add(c2);

        given(commentRepository.findAllByBoardNoAndTypeCode(anyLong(), anyString()))
                .willReturn(Optional.of(givenList));

        // when
        List<Comment> commentList = commentService.list(anyLong(), anyString());

        // then
        assertEquals(2, commentList.size());
        assertEquals(1L, commentList.get(0).getNo());
        assertEquals(100L, commentList.get(0).getBoardNo());
        assertEquals("comment1", commentList.get(0).getComment());
        assertEquals("author1", commentList.get(0).getAuthor());
        assertEquals("1001", commentList.get(0).getTypeCode());

        assertEquals(2L, commentList.get(1).getNo());
        assertEquals(100L, commentList.get(1).getBoardNo());
        assertEquals("comment2", commentList.get(1).getComment());
        assertEquals("author2", commentList.get(1).getAuthor());
        assertEquals("1001", commentList.get(1).getTypeCode());
    }
}