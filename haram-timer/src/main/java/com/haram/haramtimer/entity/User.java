package com.haram.haramtimer.entity;

// lombok
import lombok.Getter; // get 메소드 생성
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

// 여행지 테이블
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {
    // 기본키 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 AUTO_INCREMENT를 사용
    private Long id;

    // 유저 id
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    // 비밀번호
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    // 이메일
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    // 이름
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    // 생년월일
    @Column(name = "birth_date", nullable = false, length = 10)
    private String birthDate;

    // 휴대전화
    @Column(name = "phone_num", nullable = false, length = 15)
    private String phoneNum;

    // 생성자
    public User(String userId, String password, String email, String name, String birthDate, String phoneNum) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNum = phoneNum;
    }
}
