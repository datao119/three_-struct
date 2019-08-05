package com.qf.app2.enums;

import lombok.Getter;

/**
 * 2019-08-02-10:35 PM
 * <p>
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Getter
public enum DevUserStateEnum{
    LOCK(0,"账号锁定"),
    ACTIVE(1,"账号已激活,正常!"),
    ;


    private Integer state;
    private String description;

    DevUserStateEnum(Integer state, String description) {
        this.state = state;
        this.description = description;
    }
}
