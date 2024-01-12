package com.haram.haramtimer.entity;

// lombok
import lombok.Setter; // set 메소드 생성
import lombok.Builder; // builder 패턴 자동 생성
import lombok.AllArgsConstructor; // 모든 필드 값을 파라미터로 받는 생성자(id 제외)를 만듦
import lombok.NoArgsConstructor; // 파라미터가 없는 기본 생성자(id)를 생성

// jakarta
import jakarta.persistence.Table; // 테이블 지정
import jakarta.persistence.Entity; // 데이터베이스 테이블과 매핑되는 클래스
import jakarta.persistence.Id; // 엔터티의 기본 키를 지정
import jakarta.persistence.GeneratedValue; // 기본 키 값에 대한 생성자 제공
import jakarta.persistence.GenerationType; // 기본 키 값에 대한 생성 타입
import jakarta.persistence.Column; // 열 지정
import jakarta.persistence.ElementCollection;

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
