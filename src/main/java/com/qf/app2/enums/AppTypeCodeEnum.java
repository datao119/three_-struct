package com.qf.app2.enums;

import lombok.Getter;

/**
 * 2019-08-02-10:34 PM
 * <p>
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Getter
public enum AppTypeCodeEnum{

    USER_TYPE("USER_TYPE","用户类型"),
    APP_STATUS("APP_STATUS","APP状态"),
    APP_FLATFORM("APP_FLATFORM","所属平台"),
    PUBLISH_STATUS("PUBLISH_STATUS","发布状态"),

    ;


    private String typeCode;
    private String typeName;

    AppTypeCodeEnum(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }
}
