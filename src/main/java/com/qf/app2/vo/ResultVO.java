package com.qf.app2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目日期：2019-08-02-10:54 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO{
    // 0 代表成功!!
    private Integer code;

    // 默认成功
    private String msg;

    // 响应的具体数据
    private Object data;
}
