package com.qf.app2.service;

import com.qf.app2.pojo.DevUser;

import javax.mail.MessagingException;

/**
 * 2019-08-02-10:19 PM
 * <p>
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
public interface DevUserService{
    // 检查用户名是否可用
    Integer checkUsername(String username);

    // 注册功能
    void register(DevUser devUser) throws MessagingException;

    // 激活账号
    void active(String devUsername, String code);

    // 重新发送激活邮件
    void resendActiveMail(String devUsername) throws MessagingException;

    // 登录功能
    DevUser login(String devUsername, String devPassword);
}
