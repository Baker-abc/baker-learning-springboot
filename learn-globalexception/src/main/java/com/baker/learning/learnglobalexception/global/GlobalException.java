package com.baker.learning.learnglobalexception.global;

import com.baker.learning.learnglobalexception.base.RespVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @description
 * @date 2019/12/10 9:25
 */

@ControllerAdvice
@Log4j2
public class GlobalException {

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public RespVO exceptionHandler(Throwable e, HttpServletResponse httpServletResponse) {

        log.error("api异常：" + e.getMessage());

        RespVO res = new RespVO();
        res.setMessage(e.getMessage());
        res.setCode(RespVO.ERROR);

        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return res;
    }
}

