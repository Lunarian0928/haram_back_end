package com.haram.haramtimer.response.holiDeInfoResponse;

import java.util.List;

// Items는 공휴일 이벤트 리스트를 담습니다.
public class Items {
    private List<HolidayEvent> item;

    public List<HolidayEvent> getItem() {
        return item;
    }

    public void setItem(List<HolidayEvent> item) {
        this.item = item;
    }
}