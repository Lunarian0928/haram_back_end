package com.haram.haramtimer.lap;

import jakarta.persistence.Embeddable;

@Embeddable
public class StopwatchTime {
    private Integer hours;
    private Integer minutes;
    private Integer seconds;
    private Integer milliseconds;

    public StopwatchTime() {

    }

    public StopwatchTime(Integer hours, Integer minutes, Integer seconds, Integer milliseconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    public Integer getHours() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public Integer getMilliseconds() {
        return milliseconds;
    }
}
