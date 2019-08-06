package com.qf.app2.service.impl;

import com.qf.app2.App2ApplicationTests;
import com.qf.app2.service.DevUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DevUserServiceImplTest extends App2ApplicationTests{
    @Autowired
    private DevUserService devUserService;

    @Test
    public void checkUsername() {
        Integer admin = devUserService.checkUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void register() {
        //devUserService.register();
    }

    @Test
    public void active() {
        int i = 1;
        //devUserService.active("wangdana", i);
    }

    @Test
    public void resendActiveMail() {
    }

    @Test
    public void login() {
    }
}