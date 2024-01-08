package com.haram.haramtimer.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reminder")
@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_meridiem", nullable = false, length = 6)
    private String timeMeridiem;

    @Column(name = "time_hour", nullable = false)
    private int timeHour;

    @Column(name = "time_min", nullable = false)
    private int timeMin;

    @ElementCollection
    @Column(name = "days", nullable = false)
    private List<String> days;

    @Column(name = "special_day_year", nullable = false)
    private int specialDayYear;

    @Column(name = "special_day_month", nullable = false)
    private int specialDayMonth;

    @Column(name = "special_day_date", nullable = false)
    private int specialDayDate;

    @Column(name = "special_day_day", nullable = false, length = 3)
    private String specialDayDay;

    @Column(name = "holiday_option", nullable = false)
    private boolean holidayOption;

    @Column(name = "label", nullable = false, length = 255)
    private String label;

    @Column(name = "is_repeating", nullable = false)
    private boolean isRepeating;

    @Column(name = "repeat_interval", nullable = false)
    private int repeatInterval;

    @Column(name = "repeat_count", nullable = false)
    private int repeatCount;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public void setTimeMeridiem(String timeMeridiem) {
        this.timeMeridiem = timeMeridiem;
    }

    public void setTimeHour(int timeHour) {
        this.timeHour = timeHour;
    }

    public void setTimeMin(int timeMin) {
        this.timeMin = timeMin;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public void setSpecialDayYear(int specialDayYear) {
        this.specialDayYear = specialDayYear;
    }

    public void setSpecialDayMonth(int specialDayMonth) {
        this.specialDayMonth = specialDayMonth;
    }

    public void setSpecialDayDate(int specialDayDate) {
        this.specialDayDate = specialDayDate;
    }

    public void setSpecialDayDay(String specialDayDay) {
        this.specialDayDay = specialDayDay;
    }

    public void setHolidayOption(boolean holidayOption) {
        this.holidayOption = holidayOption;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setIsRepeating(boolean isRepeating) {
        this.isRepeating = isRepeating;
    }

    public void setRepeatInterval(int repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

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

    public boolean isHolidayOption() {
        return holidayOption;
    }

    public String getLabel() {
        return label;
    }

    public boolean isRepeating() {
        return isRepeating;
    }

    public int getRepeatInterval() {
        return repeatInterval;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public boolean isActive() {
        return isActive;
    }
}
