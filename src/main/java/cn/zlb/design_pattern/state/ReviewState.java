package cn.zlb.design_pattern.state;

/**
 * 已审核状态
 */
public class ReviewState extends AbstractState {


    @Override
    public void makePriceEvent(Context context) {
        context.setState(new PublishState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.REVIEWED.getValue();
    }
    
}