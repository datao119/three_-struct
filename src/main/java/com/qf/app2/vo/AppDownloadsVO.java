package com.qf.app2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目日期：2019-08-02-10:53 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppDownloadsVO{
    // 软件名称
    private String softwareName;

    // 下载量
    private Integer downloads;
}
