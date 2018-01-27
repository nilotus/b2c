package cn.edu.jit.b2c.enums;

/**
 * Created by ChenQF on 2018/1/21.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),

            ;

    private int code;

    private String msg;

    private Object data;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResultEnum(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
