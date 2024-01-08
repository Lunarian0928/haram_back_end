package com.haram.haramtimer.repository;

import com.haram.haramtimer.entity.Reminder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findAll(); // 조건없이 테이블의 전체 레코드 조회

    void deleteAllInBatch(); // 조건없이 테이블의 전체 레코드 삭제
}
