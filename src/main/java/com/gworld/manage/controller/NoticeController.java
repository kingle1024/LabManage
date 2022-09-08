package com.gworld.manage.controller;

import com.gworld.manage.comment.entity.Comment;
import com.gworld.manage.comment.model.CommentDto;
import com.gworld.manage.member.entity.Member;
import com.gworld.manage.member.service.MemberService;
import com.gworld.manage.model.Board;
import com.gworld.manage.model.BoardDto;
import com.gworld.manage.comment.service.CommentService;
import com.gworld.manage.model.BoardParam;
import com.gworld.manage.model.CommentParam;
import com.gworld.manage.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class NoticeController {
    private final NoticeService noticeService;
    private final CommentService commentService;
    private final MemberService memberService;

    @GetMapping("/notice/list.do")
    public String list(Model model){
        List<Board> list = noticeService.list();
        model.addAttribute("list", list);
        return "notices/list";
    }

    @GetMapping("/notice/detail.do")
    public String detail(BoardParam parameter,
                         Model model, Principal principal){

        long id = parameter.getId();
        BoardDto boardDto = noticeService.detail(id);
        BoardParam board = BoardParam.of(boardDto);
        model.addAttribute("board", board);

        List<CommentDto> comments =
                commentService.list(id, "1001");
        List<CommentParam> commentParams =
                CommentParam.of(comments);
        model.addAttribute("comments", commentParams);

        Member member = memberService.detail(principal.getName());
        model.addAttribute("memberName", member.getName());

        return "notices/detail";
    }
}
