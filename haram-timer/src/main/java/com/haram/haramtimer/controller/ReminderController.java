package com.haram.haramtimer.controller;

// AutoWired
import org.springframework.beans.factory.annotation.Autowired;
// RequiredArgsConstructor
import lombok.RequiredArgsConstructor;
// RestController
import org.springframework.web.bind.annotation.RestController;

// RequestMapping
import org.springframework.web.bind.annotation.RequestMapping;
// GetMapping
import org.springframework.web.bind.annotation.GetMapping;
// PostMapping
import org.springframework.web.bind.annotation.PostMapping;
// RequestBody
import org.springframework.web.bind.annotation.RequestBody;

// List
import java.util.List;

// Reminder 엔티티
import com.haram.haramtimer.entity.Reminder;
// ReminderService
import com.haram.haramtimer.service.ReminderService;
// ReminderRequest
import com.haram.haramtimer.request.ReminderRequest;
// ReminderCheckRequest
import com.haram.haramtimer.request.ReminderCheckRequest;
// ReminderDeleteRequest
import com.haram.haramtimer.request.ReminderDeleteRequest;
// ReminderUpdateRequest
import com.haram.haramtimer.request.ReminderUpdateRequest;
// ReminderActiveRequest
import com.haram.haramtimer.request.ReminderActiveRequest;

@RequiredArgsConstructor // 초기화 되지않은 final 변수에 대해 생성자를 생성
@RestController
@RequestMapping("/reminder")
public class ReminderController {
    @Autowired
    ReminderService reminderService;

    @PostMapping("/add")
    public boolean addReminder(@RequestBody ReminderRequest reminderRequest) {
        try {
            reminderService.addReminder(
                    reminderRequest.getTimeMeridiem(),
                    reminderRequest.getTimeHour(),
                    reminderRequest.getTimeMin(),
                    reminderRequest.getDays(),
                    reminderRequest.getSpecialDayYear(),
                    reminderRequest.getSpecialDayMonth(),
                    reminderRequest.getSpecialDayDate(),
                    reminderRequest.getSpecialDayDay(),
                    reminderRequest.getHolidayOption(),
                    reminderRequest.getLabel(),
                    reminderRequest.getIsRepeating(),
                    reminderRequest.getRepeatInterval(),
                    reminderRequest.getRepeatCount(),
                    reminderRequest.getIsActive());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/read")
    public List<Reminder> readAllReminders() {
        return reminderService.getAllReminders();
    }

    @PostMapping("/read_by_id")
    public Reminder readReminderById(@RequestBody ReminderCheckRequest reminderCheckRequest) {
        return reminderService.getReminderById(reminderCheckRequest.getId());
    }

    @PostMapping("/delete")
    public boolean deleteReminder(@RequestBody ReminderDeleteRequest reminderDeleteRequest) {
        return reminderService.deleteReminder(reminderDeleteRequest.getId());
    }

    @PostMapping("/update/active")
    public boolean updateReminderActive(@RequestBody ReminderActiveRequest reminderActiveRequest) {
        return reminderService.updateReminderActive(
                reminderActiveRequest.getId(),
                reminderActiveRequest.getIsActive());
    }

    @PostMapping("/update")
    public boolean updateReminder(@RequestBody ReminderUpdateRequest reminderUpdateRequest) {
        return reminderService.updateReminder(
                reminderUpdateRequest.getId(),
                reminderUpdateRequest.getTimeMeridiem(),
                reminderUpdateRequest.getTimeHour(),
                reminderUpdateRequest.getTimeMin(),
                reminderUpdateRequest.getDays(),
                reminderUpdateRequest.getSpecialDayYear(),
                reminderUpdateRequest.getSpecialDayMonth(),
                reminderUpdateRequest.getSpecialDayDate(),
                reminderUpdateRequest.getSpecialDayDay(),
                reminderUpdateRequest.getHolidayOption(),
                reminderUpdateRequest.getLabel(),
                reminderUpdateRequest.getIsRepeating(),
                reminderUpdateRequest.getRepeatInterval(),
                reminderUpdateRequest.getRepeatCount(),
                reminderUpdateRequest.getIsActive());
    }
}
