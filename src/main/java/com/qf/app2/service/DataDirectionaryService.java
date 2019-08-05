package com.qf.app2.service;

import com.qf.app2.pojo.DataDictionary;

import java.util.List;

/**
 * 项目日期：2019-08-02-10:55 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/

public interface DataDirectionaryService{
    // 根据typeCode查询字典表信息
    List<DataDictionary> findByTypeCode(String typeCode);
}
