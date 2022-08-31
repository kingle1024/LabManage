package com.gworld.manage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gworld.manage.model.Board;
import com.gworld.manage.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(NoticeController.class)
class NoticeControllerTest {
    @MockBean
    private NoticeService noticeService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void successList() throws Exception {
        List<Board> boardList = new ArrayList<>();
        boardList.add(Board.builder()
                .id(1L)
                .title("title")
                .author("author")
                .hit(2)
                .build()
        );
        boardList.add(Board.builder()
                .id(2L)
                .content("people")
                .build()
        );
        // given
        given(noticeService.list())
                .willReturn(boardList);
        // when
        // then
        mockMvc.perform(get("/board/list.do").accept(MediaType.TEXT_HTML))
//                .andExpect(status().isOk())
//                .andDo(print())
                .andExpect(content().string(containsString("<td>1</td>")))
                .andExpect(content().string(containsString("<td>title</td>")))
                .andExpect(content().string(containsString("<td>author</td>")))
                .andExpect(content().string(containsString("<td>2</td>")))
        ;
    }
}
