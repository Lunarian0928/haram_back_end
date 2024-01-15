package com.haram.haramtimer.request;

import java.util.List;

import com.haram.haramtimer.lap.Lap;

public class LapsRecordRequest {
    private String label;
    private List<Lap> laps;

    public String getLabel() {
        return label;
    }

    public List<Lap> getLaps() {
        return laps;
    }
}
