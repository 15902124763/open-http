package com.yarm.exception;

import com.yarm.common.pojo.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * @program: open-http
 * @description: controller异常处理
 * @author: yarm
 * @create: 2019-11-19 15:25
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity hadlerException(final Exception ex, final WebRequest req){
        ApiResponse<String> apiResponse = new ApiResponse<>();

        log.error("Controller异常{}",ex.getMessage());

        // 参数错误
        if(ex instanceof MethodArgumentNotValidException){
            BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();
            wrapperError(result, apiResponse);

            return new ResponseEntity<Object>(apiResponse, HttpStatus.OK);
        }

        // 其他错误
        apiResponse.setMsg("系统错误,请稍后再试");
        apiResponse.setCode(401);

        return new ResponseEntity(apiResponse, HttpStatus.OK);
    }

    private void wrapperError(BindingResult result,ApiResponse apiResponse){
        List<ObjectError> list = result.getAllErrors();
        String eMsg = "";
        if(list.size() > 0){
            eMsg = list.get(0).getDefaultMessage();
        }
        apiResponse.setCode(102);
        apiResponse.setMsg(eMsg);
    }
}