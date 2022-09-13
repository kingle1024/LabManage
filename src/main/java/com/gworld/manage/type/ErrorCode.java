package com.gworld.manage.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR("처리중 오류가 발생했습니다."),
    INVALID_REQUEST("잘못된 요청입니다."),
    NOTICE_DELETE("삭제 실패했습니다."),
    ERROR_CODE("ERROR")
    ;

    private final String description;
}
