package com.gworld.manage.controller;

import com.gworld.manage.common.model.ResponseResult;
import com.gworld.manage.model.BoardDto;
import com.gworld.manage.model.ServiceResult;
import com.gworld.manage.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiNoticeController {
    private final NoticeService noticeService;

    @PostMapping("/api/notice/del.api")
    public ResponseEntity<?> del(
            @RequestBody BoardDto boardDto
    ){
        ServiceResult result = noticeService.delete(boardDto.getId());
        if(!result.isResult()){
            ResponseResult responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }
        ResponseResult responseResult = new ResponseResult(true);
        return ResponseEntity.ok().body(responseResult);
    }
}
