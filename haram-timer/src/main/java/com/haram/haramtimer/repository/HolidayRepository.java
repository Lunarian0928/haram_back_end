package com.haram.haramtimer.repository;

import com.haram.haramtimer.entity.Holiday;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
    List<Holiday> findAll(); // 조건없이 테이블의 전체 레코드 조회

    boolean existsByYear(int year); // year로 확인

    boolean existsByYearAndMonthAndDate(int year, int month, int date); // year와 month, date로 확인

    void deleteAllInBatch(); // 조건없이 테이블의 전체 레코드 삭제
}
