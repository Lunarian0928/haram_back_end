package com.haram.haramtimer.response.holiDeInfoResponse;

// HolidayEvent는 각 공휴일 이벤트의 상세 정보를 담습니다.
public class HolidayEvent {
    private String dateKind;
    private String dateName;
    private String isHoliday;
    private int locdate;
    private int seq;

    public String getDateKind() {
        return dateKind;
    }

    public String getDateName() {
        return dateName;
    }

    public String getIsHoliday() {
        return isHoliday;
    }

    public int getLocdate() {
        return locdate;
    }

    public int getSeq() {
        return seq;
    }

    public void setDateKind(String dateKind) {
        this.dateKind = dateKind;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public void setIsHoliday(String isHoliday) {
        this.isHoliday = isHoliday;
    }

    public void setLocdate(int locdate) {
        this.locdate = locdate;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}