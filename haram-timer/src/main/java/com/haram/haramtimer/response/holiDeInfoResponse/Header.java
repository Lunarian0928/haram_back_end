package com.haram.haramtimer.response.holiDeInfoResponse;

// Header는 응답의 상태 정보를 담습니다.
public class Header {
    private String resultCode;
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setReslutMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
