package com.qf.app2.exception;

import com.qf.app2.util.ResultVOUtil;
import com.qf.app2.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 项目日期：2019-08-02-11:07 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@RestControllerAdvice
public class AppExceptionHandler{
    @ExceptionHandler(AppException.class)
    public ResultVO error(AppException ex){
        return ResultVOUtil.error(ex);
    }
}
