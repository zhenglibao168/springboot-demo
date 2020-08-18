package cn.zlb;

import cn.zlb.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;

import javax.annotation.Resource;

/**
 * Service层单元测试
 */
@RunWith(SpringRunner.class)
@Import(HelloService.class)
public class HelloServiceTest {

    @Resource
    private HelloService helloService;

    @Test
    public void sayHello() {
        String str = "this is a test";
        Assert.assertEquals(str, helloService.doTest(str));
    }
}