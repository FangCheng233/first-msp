package com.fc.msp.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/15 8:12 上午
 * @Version 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ExceptionMsg defaultErrorHandler(HttpServletRequest req, Exception e) {
        log.error("ExceptionHandler ===>" + e.getMessage());
        e.printStackTrace();
        // 这里可根据不同异常引起的类做不同处理方式
        String exceptionName = ClassUtils.getShortName(e.getClass());
        log.error("ExceptionHandler ===>" + exceptionName);
//        if (exceptionName.equals(KeeperException.NoAuthException.class.getSimpleName())) {
//
//        }
        ExceptionMsg exceptionMsg = new ExceptionMsg(e.getMessage(),exceptionName);
        return exceptionMsg;
    }
}
