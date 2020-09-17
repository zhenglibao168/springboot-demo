package cn.zlb.hook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 自定义钩子类
 * 关闭钩子在以下情景被调用：
 * 程序正常退出，即最后一个非守护线程结束时
 * 程序中执行到了System.exit()方法
 * 终端接收到了CTRL-C中断，或者注销登录
 * 通过kill命令杀死进程
 * <p>
 * 关闭钩子在以下情景不会被调用：
 * 通过kill -9命令杀死进程
 * 程序中执行到了Runtime.getRuntime().halt()方法
 * 操作系统突然崩溃，或机器掉电
 *
 * @author libao.zheng
 * @date 2020/9/17 3:00 下午
 */
@Component
public class MyShutdownHook {
    private final Logger log = LoggerFactory.getLogger(MyShutdownHook.class);
    public static final String MY_SHUTDOWNHOOK_THREAD = "MY_SHUTDOWNHOOK_THREAD";
    private Thread shutdownHook;

    @PostConstruct
    public void registerShutdownHook() {
        if (this.shutdownHook == null) {
            this.shutdownHook = new Thread(MY_SHUTDOWNHOOK_THREAD) {
                @Override
                public void run() {
                    log.info("自定义钩子方法执行...");
                }
            };
            Runtime.getRuntime().addShutdownHook(this.shutdownHook);
        }
    }
}
