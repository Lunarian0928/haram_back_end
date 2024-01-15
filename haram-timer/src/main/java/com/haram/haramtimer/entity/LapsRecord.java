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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue; // 기본 키 값에 대한 생성자 제공
import jakarta.persistence.GenerationType; // 기본 키 값에 대한 생성 타입
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column; // 열 지정
import jakarta.persistence.ElementCollection;

// List
import java.util.List;

import com.haram.haramtimer.lap.Lap;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "laps_record")
@Entity
public class LapsRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label", nullable = false, length = 250)
    private String label;

    @ElementCollection
    @CollectionTable(name = "lap", joinColumns = @JoinColumn(name = "laps_record_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "lapNumber", column = @Column(name = "lap_number")),
            @AttributeOverride(name = "elapsedTime", column = @Column(name = "elapsed_time")),
            @AttributeOverride(name = "worldTime.hours", column = @Column(name = "world_time_hours")),
            @AttributeOverride(name = "worldTime.minutes", column = @Column(name = "world_time_minutes")),
            @AttributeOverride(name = "worldTime.seconds", column = @Column(name = "world_time_seconds")),
            @AttributeOverride(name = "worldTime.milliseconds", column = @Column(name = "world_time_milliseconds")),
            @AttributeOverride(name = "totalTime.hours", column = @Column(name = "total_time_hours")),
            @AttributeOverride(name = "totalTime.minutes", column = @Column(name = "total_time_minutes")),
            @AttributeOverride(name = "totalTime.seconds", column = @Column(name = "total_time_seconds")),
            @AttributeOverride(name = "totalTime.milliseconds", column = @Column(name = "total_time_milliseconds"))
    })
    private List<Lap> laps;

    public LapsRecord(String label, List<Lap> laps) {
        this.label = label;
        this.laps = laps;
    }

}
