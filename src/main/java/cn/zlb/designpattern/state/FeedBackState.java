package cn.zlb.designpattern.state;

/**
 * 已完结状态
 */
public class FeedBackState extends AbstractState{

    @Override
    public String getCurrentState() {
        return StateEnum.FEED_BACKED.getValue();
    }
}