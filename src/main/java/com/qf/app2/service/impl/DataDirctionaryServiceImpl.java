package com.qf.app2.service.impl;

import com.qf.app2.mapper.DataDirctionaryMapper;
import com.qf.app2.pojo.DataDictionary;
import com.qf.app2.service.DataDirectionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目日期：2019-08-02-11:02 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Service
@Slf4j
public class DataDirctionaryServiceImpl implements DataDirectionaryService{
    @Autowired
    private DataDirctionaryMapper dataDirctionaryMapper;
    @Override
    public List<DataDictionary> findByTypeCode(String typeCode) {
        return dataDirctionaryMapper.findByTypeCode(typeCode);
    }
}
