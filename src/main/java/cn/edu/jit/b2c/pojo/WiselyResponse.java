package cn.edu.jit.b2c.pojo;

/**
 * Created by ChenQF on 2018/1/12.
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
