package com.gworld.manage.controller;

import com.gworld.manage.model.Board;
import com.gworld.manage.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/board/list.do")
    public String list(Model model){
        List<Board> list = boardService.list();
        model.addAttribute("list", list);
        return "boards/list";
    }
}
