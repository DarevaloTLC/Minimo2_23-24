package edu.upc.dsa.models;

public class FormResponse {
    private String msg;

    public FormResponse(String msg) {
        this.msg = msg;
    }

    public FormResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
