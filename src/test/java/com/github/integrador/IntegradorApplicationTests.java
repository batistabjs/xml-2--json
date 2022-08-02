package com.github.integrador;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.github.integrador")
class IntegradorApplicationTests {

    @Test
    public void contextLoads() {
        TestCase.assertEquals(1, 1);
    }
}
