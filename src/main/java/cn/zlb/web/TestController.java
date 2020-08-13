package cn.zlb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@RestController
public class TestController {
    // 存储已有参数，用于判断参数value是否重复，从而判断线程是否安全
    public static Set<String> set = new ConcurrentSkipListSet<>();
    @Resource
    private HttpServletRequest request;

    @RequestMapping("/test")
    public void test() throws InterruptedException {
        String value = request.getParameter("key");
        // 判断线程安全
        if (set.contains(value)) {
            System.out.println(value + "\t重复出现，request并发不安全！");
        } else {
            set.add(value);
        }
        // 模拟程序执行了一段时间
        Thread.sleep(100);
    }
}