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
public class BoardParam {
    Long id;
    String title;
    String content;
    String author;
    long hit;
    LocalDateTime registerDate;
    LocalDateTime updateDate;
    boolean deleteYn;
    String typeCode;

    public static BoardParam of(BoardDto board){
        return BoardParam.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .hit(board.getHit())
                .registerDate(board.getRegisterDate())
                .updateDate(board.getUpdateDate())
                .deleteYn(board.isDeleteYn())
                .typeCode(board.getTypeCode())
                .build();
    }
    public static List<BoardParam> of(List<BoardDto> boards){
        if(boards == null) return null;
        List<BoardParam> boardList = new ArrayList<>();
        for(BoardDto x : boards){
            boardList.add(BoardParam.of(x));
        }
        return boardList;
    }
}
