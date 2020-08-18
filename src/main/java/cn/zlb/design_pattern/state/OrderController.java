package cn.zlb.design_pattern.state;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单客户端
 *
 * @author libao.zheng
 * @date 2020/8/18 11:41 上午
 */
@RestController
public class OrderController {
    @GetMapping("order")
    public void requestOrder() {
        Context context = new Context();
        context.setState(new PublishState());
        //publish --> not pay
        context.acceptOrderEvent(context);
        //not pay --> paid
        context.payOrderEvent(context);
        //失败
        context.checkFailEvent(context);
    }
}
