package com.gworld.manage.service;

import com.gworld.manage.model.Board;
import com.gworld.manage.model.BoardDto;
import com.gworld.manage.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NoticeServiceImplTest {
    @InjectMocks
    private NoticeServiceImpl noticeService;

    @Mock
    private BoardRepository boardRepository;

    @Test
    void detailSuccess() {
        LocalDateTime now = LocalDateTime.now();
        Board board = Board.builder()
                .id(1L)
                .title("title")
                .content("content")
                .hit(1)
                .author("author")
                .register_date(now)
                .update_date(now)
                .build();

        // given
        given(boardRepository.findById(anyLong()))
                .willReturn(Optional.of(board));

        // when
        BoardDto boardDto = noticeService.detail(1L);

        // then
        assertEquals(1L, boardDto.getId());
        assertEquals("title", boardDto.getTitle());
        assertEquals("content", boardDto.getContent());
        assertEquals(1, boardDto.getHit());
        assertEquals("author", boardDto.getAuthor());
        assertEquals(now, boardDto.getRegister_date());
        assertEquals(now, boardDto.getUpdate_date());
    }
}