package cn.zlb.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller extends BaseController {
    @RequestMapping("/test2")
    public void test2() throws InterruptedException {
        String value = request.getParameter("key");
        // 判断线程安全（与TestController使用一个set进行判断）
        if (TestController.set.contains(value)) {
            System.out.println(value + "\t重复出现，request并发不安全！");
        } else {
            TestController.set.add(value);
        }
        // 模拟程序执行了一段时间
        Thread.sleep(100);
    }
}