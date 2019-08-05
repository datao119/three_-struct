package com.qf.app2.constant;

/**
 * 2019-08-03-8:18 AM
 * <p>
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
public interface AppConstant{
    // 开发者模块用户注册页面
    String DEV_USER_REGISTER = "dev/user/register";


    // 开发者模块用户登录页面
    String DEV_USER_LOGIN = "dev/user/login";


    // 开发者模块用户发送激活邮件页面
    String DEV_USER_ACTIVE = "dev/user/active";

    // 开发者用户信息在session中的key
    String DEV_SESSION_KEY = "devUser";

    // 加密次数
    int ENCRYPTION_NUMBER = 1024;

    //==================================================================

    // 开发者模块的APP首页
    String DEV_APP_INDEX = "dev/app/index";

    // 开发者模块的APP维护页面
    String DEV_APP_MAINTAIN = "dev/app/app-maintain";
}
