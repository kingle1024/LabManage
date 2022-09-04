package com.gworld.manage.service;

import com.gworld.manage.common.model.ResponseResult;
import com.gworld.manage.model.Board;
import com.gworld.manage.model.BoardDto;
import com.gworld.manage.model.ServiceResult;
import com.gworld.manage.repository.BoardRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
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
                .registerDate(now)
                .updateDate(now)
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
        assertEquals(now, boardDto.getRegisterDate());
        assertEquals(now, boardDto.getUpdateDate());
    }

    @Test
    @DisplayName("삭제 처리 성공")
    void deleteSuccess(){
        LocalDateTime now = LocalDateTime.now();
        Board board = Board.builder()
                .id(1L)
                .title("title")
                .content("content")
                .hit(1)
                .author("author")
                .registerDate(now)
                .updateDate(now)
                .deleteYn(false)
                .build();

        // given
        given(boardRepository.findById(anyLong()))
                .willReturn(Optional.of(board));

        // when
        ServiceResult result = noticeService.delete(anyLong());

        //then
        assertTrue(result.isResult());
        assertEquals("", result.getMessage());
        assertTrue(board.isDeleteYn());
    }
    @Test
    @DisplayName("long id가 잘못되었을때 실패 처리")
    void deleteFail(){
        LocalDateTime now = LocalDateTime.now();
        Board board = Board.builder()
                .id(1L)
                .title("title")
                .content("content")
                .hit(1)
                .author("author")
                .registerDate(now)
                .updateDate(now)
                .deleteYn(false)
                .build();

        // given
        given(boardRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        // when
        ServiceResult result = noticeService.delete(anyLong());

        //then
        assertFalse(result.isResult());
        assertEquals("게시글 정보가 존재하지 않습니다.", result.getMessage());
        assertFalse(board.isDeleteYn());
    }
}