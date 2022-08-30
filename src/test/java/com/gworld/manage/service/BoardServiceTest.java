package com.gworld.manage.service;

import com.gworld.manage.model.Board;
import com.gworld.manage.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    @InjectMocks
    private BoardServiceImpl boardService;

    @Mock
    private BoardRepository boardRepository;

    @Test
    void listSuccess(){
        List<Board> list = new ArrayList<>();
        Board b1 = Board.builder()
                .id(1L)
                .title("title")
                .content("content")
                .author("author")
                .hit(2)
                .build();
        list.add(b1);

        //given
        given(boardRepository.findAll())
                .willReturn(list);

        //when
        List<Board> whenList1 = boardService.list();

        //then
        assertEquals(1, whenList1.size());
        assertEquals(1, whenList1.get(0).getId());
        assertEquals("title", whenList1.get(0).getTitle());
        assertEquals("content", whenList1.get(0).getContent());
        assertEquals("author", whenList1.get(0).getAuthor());
        assertEquals(2, whenList1.get(0).getHit());
    }
}
