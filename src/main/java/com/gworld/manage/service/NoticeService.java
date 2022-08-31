package com.gworld.manage.service;

import com.gworld.manage.model.Board;
import com.gworld.manage.model.BoardDto;

import java.util.List;

public interface NoticeService {
    List<Board> list();

    BoardDto detail(long id);
}
