package com.qf.app2.util;

import com.qf.app2.exception.AppException;
import com.qf.app2.vo.ResultVO;

/**
 * 项目日期：2019-08-02-11:08 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/

public class ResultVOUtil{
    public static ResultVO success(Object data){
        return new ResultVO(0,"成功",data);
    }
    public static ResultVO success(){
        return ResultVOUtil.success(null);
    }

    public static ResultVO error(AppException ex){
        return new ResultVO(ex.getCode(),ex.getMessage(),null);
    }
}
