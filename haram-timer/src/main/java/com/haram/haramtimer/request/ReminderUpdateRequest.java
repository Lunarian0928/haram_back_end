package com.haram.haramtimer.request;

import java.util.List;

public class ReminderUpdateRequest {
    private Long id;
    private String timeMeridiem;
    private int timeHour;
    private int timeMin;
    private List<String> days;
    private int specialDayYear;
    private int specialDayMonth;
    private int specialDayDate;
    private String specialDayDay;
    private boolean holidayOption;
    private String label;
    private boolean isRepeating;
    private int repeatInterval;
    private int repeatCount;
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public String getTimeMeridiem() {
        return timeMeridiem;
    }

    public int getTimeHour() {
        return timeHour;
    }

    public int getTimeMin() {
        return timeMin;
    }

    public List<String> getDays() {
        return days;
    }

    public int getSpecialDayYear() {
        return specialDayYear;
    }

    public int getSpecialDayMonth() {
        return specialDayMonth;
    }

    public int getSpecialDayDate() {
        return specialDayDate;
    }

    public String getSpecialDayDay() {
        return specialDayDay;
    }

    public boolean getHolidayOption() {
        return holidayOption;
    }

    public String getLabel() {
        return label;
    }

    public boolean getIsRepeating() {
        return isRepeating;
    }

    public int getRepeatInterval() {
        return repeatInterval;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public boolean getIsActive() {
        return isActive;
    }
}
