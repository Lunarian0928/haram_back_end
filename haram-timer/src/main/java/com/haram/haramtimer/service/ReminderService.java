package com.haram.haramtimer.service;

import com.haram.haramtimer.entity.Reminder;
import com.haram.haramtimer.repository.ReminderRepository;

// Service 어노테이션 
import org.springframework.stereotype.Service;

// 리스트
import java.util.List;
// Optional
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ReminderService {
    @Autowired
    ReminderRepository reminderRepository;

    public boolean addReminder(String timeMeridiem, int timeHour, int timeMin, List<String> days, int specialDayYear,
            int specialDayMonth, int specialDayDate, String specialDayDay, boolean holidayOption, String label,
            boolean isRepeating, int repeatInterval, int repeatCount, boolean isActive) {
        try {
            // Reminder 객체 생성
            Reminder reminder = new Reminder();

            // 필드값 설정
            reminder.setTimeMeridiem(timeMeridiem);
            reminder.setTimeHour(timeHour);
            reminder.setTimeMin(timeMin);
            reminder.setDays(days);
            reminder.setSpecialDayYear(specialDayYear);
            reminder.setSpecialDayMonth(specialDayMonth);
            reminder.setSpecialDayDate(specialDayDate);
            reminder.setSpecialDayDay(specialDayDay);
            reminder.setHolidayOption(holidayOption);
            reminder.setLabel(label);
            reminder.setIsRepeating(isRepeating);
            reminder.setRepeatInterval(repeatInterval);
            reminder.setRepeatCount(repeatCount);
            reminder.setIsActive(isActive);

            // 객체 확인
            System.out.println(reminder);

            // 객체 저장
            reminderRepository.save(reminder);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public boolean deleteReminder(Long id) {
        try {
            reminderRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // 더 자세한 예외 처리 로직을 추가할 수 있습니다.
            return false;
        }
    }

    public boolean updateReminder(Long id, String timeMeridiem, int timeHour, int timeMin, List<String> days,
            int specialDayYear,
            int specialDayMonth, int specialDayDate, String specialDayDay, boolean holidayOption, String label,
            boolean isRepeating, int repeatInterval, int repeatCount, boolean isActive) {
        Optional<Reminder> optionalReminder = reminderRepository.findById(id);

        if (optionalReminder.isPresent()) {
            Reminder reminder = optionalReminder.get();
            reminder.setTimeMeridiem(timeMeridiem);
            reminder.setTimeHour(timeHour);
            reminder.setTimeMin(timeMin);
            reminder.setDays(days);
            reminder.setSpecialDayYear(specialDayYear);
            reminder.setSpecialDayMonth(specialDayMonth);
            reminder.setSpecialDayDate(specialDayDate);
            reminder.setSpecialDayDay(specialDayDay);
            reminder.setHolidayOption(holidayOption);
            reminder.setLabel(label);
            reminder.setIsRepeating(isRepeating);
            reminder.setRepeatInterval(repeatInterval);
            reminder.setRepeatCount(repeatCount);
            reminder.setIsActive(isActive);
            reminderRepository.save(reminder);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateReminderActive(Long id, boolean isActive) {
        Optional<Reminder> optionalReminder = reminderRepository.findById(id);

        if (optionalReminder.isPresent()) {
            Reminder reminder = optionalReminder.get();
            reminder.setIsActive(isActive);
            reminderRepository.save(reminder);
            return true;
        } else {
            return false;
        }
    }
}
