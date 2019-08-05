package com.qf.app2.controller;

import com.qf.app2.enums.ResultEnum;
import com.qf.app2.exception.AppException;
import com.qf.app2.pojo.DevUser;
import com.qf.app2.service.DevUserService;
import com.qf.app2.util.ResultVOUtil;
import com.qf.app2.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.qf.app2.constant.AppConstant.*;

/**
 * 项目日期：2019-08-03-8:32 AM
 * 简单描述：
 * 没有伴随着痛苦的教训是没有什么意义的
 * <p>
 * 人不作出任何牺牲，就得不到任何收获
 * <p>
 * 但是一旦超越了自我就能获得无可取代的钢之心
 **/
@Controller
@RequestMapping("/dev/user")
@Slf4j
public class DevUsercontroller extends BaseController{
    @Autowired
    private DevUserService devUserService;

    //跳转到注册页面
    @GetMapping("/register-ui")
    public String registerUI(){
        //转发页面
        return DEV_USER_REGISTER;
    }
    @PostMapping("/check-username")
    @ResponseBody
    public ResultVO checkUsername(String username){
        //1. 校验参数合法性.
        if(StringUtils.isEmpty(username)){
            // 参数不合法.
            log.info("【异步校验用户名】 参数不合法 username = {} .",username);
            throw new AppException(ResultEnum.PARAM_ERROR);
        }
        //2. 调用service查询是否可用.
        Integer data = devUserService.checkUsername(username);
        //3. 响应数据.
        return ResultVOUtil.success(data);
    }
    // 执行注册功能.
    @PostMapping("/register")
    @ResponseBody
    public ResultVO register(@Valid DevUser devUser, BindingResult bindingResult) throws MessagingException {
        //1. 校验参数合法性.
        if(bindingResult.hasErrors()){
            // 参数不合法.
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.info("【注册账号】 参数不合法 devUser = {}." ,devUser);
            throw new AppException(ResultEnum.PARAM_ERROR.getCode(),msg);
        }

        //2. 调用service执行注册.
        devUserService.register(devUser);

        //3. 成功!
        return ResultVOUtil.success();
    }
    // 激活账号
    //<a href='http://localhost/dev/user/active?devUsername=%s&code=%s'>激活账号</a>
    @GetMapping("/active")
    public String active(@RequestParam String devUsername,
                         @RequestParam String code,
                         Model model){
        try {
            //1. 调用service激活账号.
            devUserService.active(devUsername,code);

            //2. 响应成功的页面.
            model.addAttribute("success","<a href='/dev/user/login-ui'>点我登录</a>");
            return "success";
        } catch (AppException e) {
            e.printStackTrace();
            return "error";
        }
    }

    // 重新发送用户的激活邮件
    @GetMapping("/resend-active-mail")
    @ResponseBody
    public ResultVO resendActiveMail(String devUsername) throws MessagingException {
        //1. 校验参数合法性.
        if(StringUtils.isEmpty(devUsername)){
            // 参数不合法.
            log.info("【重新发送激活邮件】 参数不合法. devUsername = {}.",devUsername);
            throw new AppException(ResultEnum.PARAM_ERROR);
        }

        //2. 调用service发送激活邮件
        devUserService.resendActiveMail(devUsername);

        //3. 响应正确数据
        return ResultVOUtil.success();
    }
    // 跳转到登录页面
    @GetMapping("/login-ui")
    public String loginUI(){
        return DEV_USER_LOGIN;
    }




    // 跳转到重新发送激活账号的页面
    @GetMapping("/active-ui")
    public String activeUI(){
        return DEV_USER_ACTIVE;
    }


    // 执行登录.
    @PostMapping("/login")
    @ResponseBody
    public ResultVO login(String devUsername, String devPassword, HttpSession session){
        //1. 校验参数.
        if(StringUtils.isEmpty(devUsername) || StringUtils.isEmpty(devPassword)){
            log.info("【登录功能】 参数不合法. devUsername = {}, devPassword = {}",devUsername,devPassword);
            throw new AppException(ResultEnum.PARAM_ERROR);
        }
        //2. 调用service,并返回DevUser.
        DevUser devUser = devUserService.login(devUsername,devPassword);
        //3. 将用户的信息放到session中.
        session.setAttribute(DEV_SESSION_KEY,devUser);
        //4. 响应success.
        return ResultVOUtil.success();
    }

}
