package cn.zlb.web;

import cn.zlb.bo.User;
import cn.zlb.service.HelloService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

@RestController
@Configuration
@EnableSwagger2
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四", required = true),
            @ApiImplicitParam(name = "mobile", value = "手机号码", defaultValue = "13688888888", required = true),
            @ApiImplicitParam(name = "email", value = "电子邮件", defaultValue = "zhenglibao@163.com", required = true)
    })
    public User hello(@RequestParam String username, @RequestParam String mobile, @RequestParam String email) {
        LOG.info("welcome to coming");
        helloService.sayHello();
        return new User(1001L, username, mobile, email);
    }
}
