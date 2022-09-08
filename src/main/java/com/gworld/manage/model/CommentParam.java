package com.gworld.manage.model;

import com.gworld.manage.comment.model.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CommentParam {
    long no;
    long boardNo;
    String author;
    String comment;
    LocalDateTime registerDate;
    LocalDateTime updateDate;
    String typeCode;

    public static CommentParam of(CommentDto comment){
        return CommentParam.builder()
                .no(comment.getNo())
                .boardNo(comment.getBoardNo())
                .author(comment.getAuthor())
                .comment(comment.getComment())
                .registerDate(comment.getRegisterDate())
                .updateDate(comment.getUpdateDate())
                .typeCode(comment.getTypeCode())
                .build();
    }
    public static List<CommentParam> of(List<CommentDto> comments){
        if(comments == null) return null;
        List<CommentParam> commentList = new ArrayList<>();
        for(CommentDto c : comments){
            commentList.add(CommentParam.of(c));
        }
        return commentList;
    }
}