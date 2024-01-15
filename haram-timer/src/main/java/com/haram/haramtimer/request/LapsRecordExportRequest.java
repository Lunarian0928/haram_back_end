package com.haram.haramtimer.request;

import com.haram.haramtimer.lap.Lap;

import java.util.List;

public class LapsRecordExportRequest {
    private String label;
    private List<Lap> laps;

    public String getLabel() {
        return label;
    }

    public List<Lap> getLaps() {
        return laps;
    }
}
