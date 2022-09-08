package com.gworld.manage.comment.model;

import com.gworld.manage.comment.entity.Comment;
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
public class CommentDto {
    long no;
    long boardNo;
    String author;
    String comment;
    LocalDateTime registerDate;
    LocalDateTime updateDate;
    String typeCode;

    public static CommentDto of(Comment comment){
        return CommentDto.builder()
                .no(comment.getNo())
                .boardNo(comment.getBoardNo())
                .author(comment.getAuthor())
                .comment(comment.getComment())
                .registerDate(comment.getRegisterDate())
                .updateDate(comment.getUpdateDate())
                .typeCode(comment.getTypeCode())
                .build();
    }
    public static List<CommentDto> of(List<Comment> comments){
        if(comments == null) return null;
        List<CommentDto> commentList = new ArrayList<>();
        for(Comment c : comments){
            commentList.add(CommentDto.of(c));
        }
        return commentList;
    }
}
