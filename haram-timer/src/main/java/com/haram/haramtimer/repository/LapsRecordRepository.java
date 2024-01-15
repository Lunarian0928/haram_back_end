package com.haram.haramtimer.repository;

import com.haram.haramtimer.entity.LapsRecord;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LapsRecordRepository extends JpaRepository<LapsRecord, Long> {
    List<LapsRecord> findAll(); // 조건없이 테이블의 전체 레코드 조회

    LapsRecord findByLabel(String label);

    void deleteAllInBatch(); // 조건없이 테이블의 전체 레코드 삭제
}
