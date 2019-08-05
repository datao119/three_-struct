package com.qf.app2.service.impl;

import com.qf.app2.enums.DevUserStateEnum;
import com.qf.app2.enums.ResultEnum;
import com.qf.app2.exception.AppException;
import com.qf.app2.mapper.DevUserMapper;
import com.qf.app2.pojo.DevUser;
import com.qf.app2.service.DevUserService;
import com.qf.app2.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.UUID;

import static com.qf.app2.constant.AppConstant.ENCRYPTION_NUMBER;

/**
 * 项目日期：2019-08-02-10:20 PM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Service
@Slf4j
public class DevUserServiceImpl implements DevUserService{

    @Autowired
    private DevUserMapper devUserMapper;
    @Autowired
    private MailService mailService;

    //发送用户激活邮件
    private void sendActiveMail(DevUser devUser) throws MessagingException{
        String content = String.format(
                "<a href='http://localhost/dev/user/active?devUsername=%s&code=%s'>激活账号</a>",
                devUser.getDevUsername(), devUser.getDevCode());
        mailService.sendSimpleMail(devUser.getDevEmail(),"APP管理平台,平台用户激活账号", content);
    }
    @Override
    public Integer checkUsername(String username) {
        //调用mapper
        Integer count = devUserMapper.findByDevUsername(username);
        if(count > 1){
            // 记录error日志
            log.error("【异步校验用户名】 用户名存在多个 username = {}.",username);
        }
        //3. 返回count
        return count;
    }

    @Override
    @Transactional
    public void register(DevUser devUser) throws MessagingException {
        //设置用户状态 (默认为锁定)
        devUser.setDevState(DevUserStateEnum.LOCK.getState());

        //生成,并且对密码加密
        String salt = UUID.randomUUID().toString();
        String newPwd = new Md5Hash(devUser.getDevPassword(), salt, ENCRYPTION_NUMBER).toString();
        devUser.setDevPassword(newPwd);
        devUser.setDevSalt(salt);
        //3. 生成Code码.
                String code = System.currentTimeMillis() + UUID.randomUUID().toString();
        devUser.setDevCode(code);
        //4. 保存到数据库.
        int count = devUserMapper.insertSelective(devUser);

        //5. 判断添加是否成功.
        if(count != 1){
            log.error("【注册账号】 注册账号失败 devUser = {}.",devUser);
            throw new AppException(ResultEnum.DEV_USER_REGISTER_ERROR);
        }

        //6. 发送邮件.
        sendActiveMail(devUser);
    }

    @Override
    @Transactional
    public void active(String devUsername, String code) {
        //封装参数
        DevUser param = new DevUser();
        param.setDevUsername(devUsername);
        param.setDevCode(code);
        //2. 查询用户信息.
        DevUser devUser = devUserMapper.selectOne(param);
        //3. 判断用户信息是否为null
        if(devUser == null){
            log.info("【激活账号】,当前激活路径已失效!!! param = {}.",param);
            throw new AppException(ResultEnum.DEV_USER_ACTIVE_ERROR);
        }
        //修改用户信息devUser属性
        devUser.setDevState(DevUserStateEnum.ACTIVE.getState());
        devUser.setDevCode(null);
        //执行修改
        int count = devUserMapper.updateByPrimaryKey(devUser);
        if(count != 1){
            log.info("【激活账号】,当前激活路径已失效!!! param = {}.",param);
            throw new AppException(ResultEnum.DEV_USER_UPDATE_ERROR);
        }

    }

    @Override
    public void resendActiveMail(String devUsername) throws MessagingException {
        //根据用户名查询用户信息
        DevUser param=new DevUser();
        param.setDevUsername(devUsername);
        DevUser devUser = devUserMapper.selectOne(param);
        if(devUser == null){
            log.info("【重新发送邮件】 用户不存在! param = {}",param);
            throw new AppException(ResultEnum.DEV_USER_NOT_EXISTS);
        }
        //3. 判断state和code码
        if(devUser.getDevState() == DevUserStateEnum.ACTIVE.getState() || devUser.getDevState() == null){
            // 用户信息错误.
            log.info("【重新发送邮件】 用户信息错误! devUser = {}",devUser);
            throw new AppException(ResultEnum.DEV_USER_INFO_ERROR);
        }
        //4. 发送激活邮件.
        sendActiveMail(devUser);
    }

    @Override
    public DevUser login(String devUsername, String devPassword) {
        //调用mapper根据用户查询用户信息
        DevUser param = new DevUser();
        param.setDevUsername(devUsername);
        DevUser devUser = devUserMapper.selectOne(param);


        //        2. 判断用户信息为null.
        if(devUser == null){
            // 用户名错误
            log.info("【登录功能】 用户名错误 devUsername = {}",devUsername);
            throw new AppException(ResultEnum.DEV_USER_NOT_EXISTS);
        }
//        3. 判断用户是否已激活
        if(devUser.getDevState() != DevUserStateEnum.ACTIVE.getState()){
            // 用户未激活
            log.info("【登录功能】 用户未激活 devUser = {}",devUser);
            throw new AppException(ResultEnum.DEV_USER_NOT_ACTIVE);
        }
//        4. 判断密码是否一致.
        String newPwd = new Md5Hash(devPassword,devUser.getDevSalt(),ENCRYPTION_NUMBER).toString();
        if(!devUser.getDevPassword().equals(newPwd)){
            // 密码错误.
            log.info("【登录功能】 用户名错误 devUser = {},devPassword = {}",devUser,devPassword);
            throw new AppException(ResultEnum.DEV_USER_PASSWORD_ERROR);
        }
//        5. 返回用户信息.
        return devUser;
    }
}
