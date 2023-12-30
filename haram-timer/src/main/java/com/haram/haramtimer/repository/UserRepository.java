package com.haram.haramtimer.repository;

import com.haram.haramtimer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll(); // 조건없이 테이블의 전체 레코드 조회

    boolean existsByUserId(String userId); // 유저 아이디로 유저 존재 여부 확인

    boolean existsByPassword(String password); // 패스워드로 유저 존재 여부 확인

    boolean existsByName(String name); // 이름으로 유저 존재 여부 확인

    User findByUserId(String userId); // 유저 아이디로 유저 조회

    List<User> findByName(String name);

    void deleteAllInBatch(); // 조건없이 테이블의 전체 레코드 삭제
}
