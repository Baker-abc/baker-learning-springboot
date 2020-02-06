package com.baker.learning.learnshirojwt.aspect;

import com.baker.learning.learnshirojwt.exception.UnauthorizedException;
import com.baker.learning.learnshirojwt.model.req.RespVO;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public RespVO handle401(ShiroException e) {
        return new RespVO(401, e.getMessage(), null);
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public RespVO handle401() {
        return new RespVO(401, "Unauthorized", null);
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public RespVO globalException(HttpServletRequest request, Throwable ex) {
        return new RespVO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
    }

//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return HttpStatus.valueOf(statusCode);
//    }
}

