package cn.zlb.designpattern.state;

/**
 * 订单状态接口
 *
 * @author libao.zheng
 * @date 2020/8/18 11:30 上午
 */
public interface OrderState {
    void updateState(OrderContext orderContext);
}
