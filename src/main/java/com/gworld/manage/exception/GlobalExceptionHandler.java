package com.gworld.manage.exception;

import com.gworld.manage.common.model.ResponseResult;
import com.gworld.manage.dto.ErrorResponse;
import com.gworld.manage.model.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.gworld.manage.type.ErrorCode.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoticeException.class)
    public ErrorResponse handleAccountException(NoticeException e){
        log.error("{} is occured.", e.getErrorCode());
        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("MethodArgumentNotValidException is occurred.", e);
        ResponseResult responseResult;
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();

        responseResult = new ResponseResult(false, fieldError.getDefaultMessage());

        return ResponseEntity.ok().body(responseResult);
    }
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e){
        log.error("Exception is occurred.", e);
        return new ErrorResponse(
                INTERNAL_SERVER_ERROR,
                INTERNAL_SERVER_ERROR.getDescription()
        );
    }

}
