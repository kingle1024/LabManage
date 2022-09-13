package com.gworld.manage.exception;

import com.gworld.manage.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeException extends RuntimeException{
    private ErrorCode errorCode;
    private String errorMessage;

    public NoticeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
