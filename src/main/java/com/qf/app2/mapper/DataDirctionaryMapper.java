package com.qf.app2.mapper;

import com.qf.app2.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 2019-08-02-9:45 PM
 * <p>
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
public interface DataDirctionaryMapper extends Mapper<DataDictionary>{

    List<DataDictionary>findByTypeCode(@Param("typeCode")String typeCode);
}
