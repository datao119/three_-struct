package com.qf.app2.exception;

import com.qf.app2.enums.ResultEnum;
import lombok.Getter;

/**
 * 项目日期：2019-08-02-11:06 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Getter
public class AppException extends RuntimeException{
    private Integer code;
    public AppException(Integer code , String message) {
        super(message);
        this.code = code;
    }

    public AppException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
