package com.gworld.manage.controller;

import com.gworld.manage.model.Board;
import com.gworld.manage.model.BoardDto;
import com.gworld.manage.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class NoticeController {
    private final NoticeService noticeService;
    @GetMapping("/notice/list.do")
    public String list(Model model){
        List<Board> list = noticeService.list();
        model.addAttribute("list", list);
        return "notices/list";
    }

    @GetMapping("/notice/detail.do")
    public String detail(BoardDto boardDto,
                         Model model){
        BoardDto board = noticeService.detail(boardDto.getId());
        model.addAttribute("board", board);

        return "notices/detail";
    }
}
