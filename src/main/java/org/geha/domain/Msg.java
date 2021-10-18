package org.geha.domain;
/*
  User: Yemao Luo
  Date: 2021/10/18
  Time: 16:49
*/

public class Msg {

    private String message;
    private Boolean code;

    public Msg() {
    }

    public Msg(String message, Boolean code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getCode() {
        return code;
    }

    public void setCode(Boolean code) {
        this.code = code;
    }
}
