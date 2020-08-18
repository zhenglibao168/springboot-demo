package cn.zlb.design_pattern.singletion;

import java.io.Serializable;

public class SingletonIn implements Serializable {

    private static final long serialVersionUID = -2424536714640756316L;

    private SingletonIn() {
        //防止反射生成对象
        throw new RuntimeException("只能单例获取");
    }

    private static class SingletonInHolder {
        private static final SingletonIn singletonIn = new SingletonIn();
    }

    public static SingletonIn getSingletonIn() {
        return SingletonInHolder.singletonIn;
    }

    /**
     * 防止序列化生成对象
     *
     * @return
     */
    private Object readResolve() {
        return getSingletonIn();
    }

    public static void main(String[] args) {
        SingletonIn singleton = getSingletonIn();
    }
}