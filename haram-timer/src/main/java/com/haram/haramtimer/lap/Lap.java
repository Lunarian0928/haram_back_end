package com.haram.haramtimer.lap;

import jakarta.persistence.Embeddable;

@Embeddable
public class Lap {
    private Integer lapNumber;
    private Integer elapsedTime;
    private StopwatchTime worldTime;
    private StopwatchTime totalTime;

    public Lap() {

    }

    public Lap(Integer lapNumber, Integer elapsedTime, StopwatchTime worldTime, StopwatchTime totalTime) {
        this.lapNumber = lapNumber;
        this.elapsedTime = elapsedTime;
        this.worldTime = worldTime;
        this.totalTime = totalTime;
    }

    public Integer getLapNumber() {
        return lapNumber;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public StopwatchTime getWorldTime() {
        return worldTime;
    }

    public StopwatchTime getTotalTime() {
        return totalTime;
    }
}
