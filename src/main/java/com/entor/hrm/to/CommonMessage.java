package com.entor.hrm.to;

public class CommonMessage {
    private String message;

    public CommonMessage() {
    }

    public CommonMessage(String message) {
        System.out.println("运用到了提示信息对象");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
