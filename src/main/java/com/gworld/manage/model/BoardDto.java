package com.gworld.manage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    Long id;
    String title;
    String content;
    String author;
    long hit;
    LocalDateTime register_date;
    LocalDateTime update_date;
    boolean delete_yn;
    String type_code;


    public static BoardDto of(Board board){
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .hit(board.getHit())
                .register_date(board.getRegister_date())
                .update_date(board.getUpdate_date())
                .delete_yn(board.isDelete_yn())
                .type_code(board.getType_code())
                .build();
    }
    public static List<BoardDto> of(List<Board> boards){
        if(boards == null) return null;
        List<BoardDto> boardList = new ArrayList<>();
        for(Board x : boards){
            boardList.add(BoardDto.of(x));
        }
        return boardList;
    }
}
