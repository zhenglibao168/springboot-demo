package cn.zlb.designpattern.state;

import org.springframework.stereotype.Component;

/**
 * 持有订单状态的类
 *
 * @author libao.zheng
 * @date 2020/8/18 11:32 上午
 */
@Component
public class OrderContext {
    private OrderState orderState;

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void updateState() {
        if (orderState != null) {
            orderState.updateState(this);
        }
    }
}
