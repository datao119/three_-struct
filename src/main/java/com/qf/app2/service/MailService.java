package com.qf.app2.service;

import javax.mail.MessagingException;

/**
 * 2019-08-02-9:47 PM
 * <p>
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
public interface MailService{
    //发送邮件
    void sendSimpleMail(String to ,String subject,String content)throws MessagingException;;
}
