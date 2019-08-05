package com.qf.app2.mapper;

import com.qf.app2.pojo.DevUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 2019-08-02-9:36 PM
 * <p>
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
public interface DevUserMapper extends Mapper<DevUser>{

    @Select("select count(*) from dev_user where dev_username=#{devusername}")
    Integer findByDevUsername(@Param("devUsername") String devUsername);

    //删除state=0 并且创建时间超过三天的
    @Delete("delete from dev_user where created<now()-interval 3 day and dev_state=#{state}")
    Integer deleteByDevStateAndCreateThreeDays(@Param("state") Integer state);

}
