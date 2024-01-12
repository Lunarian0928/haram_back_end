package com.haram.haramtimer.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import com.haram.haramtimer.repository.HolidayRepository;
import com.haram.haramtimer.service.SpcdeInfoService;

@RestController
public class PublicHolidayController {
    @Autowired
    SpcdeInfoService spcdeInfoService;

    @Autowired
    HolidayRepository holidayRepository;

    @GetMapping("/check_holiday")
    public boolean checkHoliday(@RequestParam int year, @RequestParam int month, @RequestParam int date) {
        if (!holidayRepository.existsByYear(year)) {
            spcdeInfoService.saveHolidays(year);
        }

        return holidayRepository.existsByYearAndMonthAndDate(year, month, date);
    }
}
