package cn.zlb.designpattern.state;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单客户端
 *
 * @author libao.zheng
 * @date 2020/8/18 11:41 上午
 */
@RestController
public class OrderController {
    @Resource
    private OrderContext orderContext;

    @Resource
    private UnPaidOrderState unPaidOrderState;

    @GetMapping("order")
    public void requestOrder() {
        orderContext.setOrderState(unPaidOrderState);
        orderContext.updateState();
        orderContext.updateState();
        orderContext.updateState();
    }
}
