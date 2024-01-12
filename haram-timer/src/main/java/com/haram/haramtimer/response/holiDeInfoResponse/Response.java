package com.haram.haramtimer.response.holiDeInfoResponse;

// Response는 전체 응답을 관리합니다.
public class Response {
    private Header header;
    private Body body;

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
