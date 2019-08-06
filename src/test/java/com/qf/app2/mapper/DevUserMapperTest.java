package com.qf.app2.mapper;

import com.qf.app2.App2ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DevUserMapperTest extends App2ApplicationTests{

    @Autowired
    private DevUserMapper devUserMapper;



    @Test
    public void findByDevUsername() {
        Integer admin = devUserMapper.findByDevUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void deleteByDevStateAndCreateThreeDays() {
        Integer integer = devUserMapper.deleteByDevStateAndCreateThreeDays(0);
        System.out.println(integer);
    }
}