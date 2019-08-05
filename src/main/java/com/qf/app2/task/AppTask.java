package com.qf.app2.task;

import com.qf.app2.enums.DevUserStateEnum;
import com.qf.app2.mapper.DevUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 项目日期：2019-08-03-8:08 AM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Component
@Slf4j
public class AppTask{
    @Autowired
    private DevUserMapper devUserMapper;

    @Scheduled(cron = "0 0 5 * * ?")
    public void deleteNotActiveDevUser(){
        Integer count = devUserMapper.deleteByDevStateAndCreateThreeDays(DevUserStateEnum.LOCK.getState());
        log.info("【定时删除未激活用户】 今天删除了 {} 条",count);
    }
}
