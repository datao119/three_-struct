package com.qf.app2.enums;

import lombok.Getter;

/**
 * 2019-08-02-10:31 PM
 * <p>
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Getter
public enum ResultEnum{

    PARAM_ERROR(1,"参数不合法!"),
    DEV_USER_REGISTER_ERROR(41,"开发者平台注册账号失败!"),
    DEV_USER_ACTIVE_ERROR(51,"激活账号失败!!"),
    DEV_USER_UPDATE_ERROR(66,"修改开发者用户信息失败!!"),
    DEV_USER_INFO_ERROR(72,"当前开发者用户信息错误!!"),
    DEV_USER_NOT_EXISTS(71,"当前用户不存在!!"),
    DEV_USER_PASSWORD_ERROR(73,"密码错误!!"),
    DEV_USER_NOT_ACTIVE(74,"用户未激活!!"),
    ;

    private Integer code;
    private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // ResultEnum(Integer code,String msg){}
}
