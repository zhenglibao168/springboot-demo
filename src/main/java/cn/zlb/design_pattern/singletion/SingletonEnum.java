package cn.zlb.design_pattern.singletion;

public enum SingletonEnum {

    INSTANCE(1,"i am singleton");

    private int code;

    private String message;
    
    SingletonEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public final int getCode() {
        return code;
    }
    
    public final String getMessage() {
        return message;
    }
}