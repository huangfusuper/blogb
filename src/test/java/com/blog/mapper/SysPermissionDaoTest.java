package com.blog.mapper;

import com.blog.BlogApplication;
import com.blog.dataobject.SysPermission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
public class SysPermissionDaoTest {
    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Test
    public void test(){
        List<SysPermission> allByRoleIds = sysPermissionDao.findAllByRoleIds(Arrays.asList(1));
        Assert.assertNotNull(allByRoleIds);
    }
}