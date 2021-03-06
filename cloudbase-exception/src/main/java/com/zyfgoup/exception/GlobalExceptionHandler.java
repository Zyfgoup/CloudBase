package com.zyfgoup.exception;

import com.sun.deploy.security.BadCertificateDialog;
import com.zyfgoup.entity.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author Zyfgoup
 * @Date 2020/12/1 11:15
 * @Description
 * 全局异常处理类
 * @RestControllerAdvive处理全部Controller 或者指定某些Controller
 * = ControllerAdvice + ResponseBody
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常的通用  具体的异常信息在ErrorCode和对应的自定义异常类里定义
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleAppException(BaseException ex, HttpServletRequest request){
        return new ResponseEntity<>(Result.fail(ex.getErrorCode(),ex.getErrorMsg(),null),new HttpHeaders(),ex.getStatus());
    }


//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public Result handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
//        return Result.fail(ex.getErrorCode(),ex.getErrorMsg(),null);
//    }

    /**
     *  不太确定的错误 统一处理
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAppException(Exception ex, HttpServletRequest request){
        return new ResponseEntity<>(Result.fail(1000,ex.getMessage(),null),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
