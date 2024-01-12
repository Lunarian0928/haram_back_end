package com.haram.haramtimer.response.holiDeInfoResponse;

// Body는 Items 객체, numOfRows, pageNo, totalCount를 담습니다.
public class Body {
    private Items items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;

    public Items getItems() {
        return items;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
