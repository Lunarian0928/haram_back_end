package com.haram.haramtimer.controller;

// RestController
import org.springframework.web.bind.annotation.RestController;
// GetMapping
import org.springframework.web.bind.annotation.GetMapping;
// PathVariable
import org.springframework.web.bind.annotation.PathVariable;

// autowired
import org.springframework.beans.factory.annotation.Autowired;
// HolidayRepository
import com.haram.haramtimer.repository.HolidayRepository;

// SpcdeInfoService
import com.haram.haramtimer.service.SpcdeInfoService;

@RestController
public class PublicHolidayController {
    @Autowired
    SpcdeInfoService spcdeInfoService;

    @Autowired
    HolidayRepository holidayRepository;

    @GetMapping("/check_holiday?year={year}?month={month}?date={date}")
    public boolean checkHoliday(@PathVariable int year, @PathVariable int month, @PathVariable int date) {
        if (!holidayRepository.existsByYear(year)) {
            spcdeInfoService.saveHolidays(year);
        }

        return holidayRepository.existsByYearAndMonthAndDate(year, month, date);
    }
}