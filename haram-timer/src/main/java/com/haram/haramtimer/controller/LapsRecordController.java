package com.haram.haramtimer.controller;

// RestController
import org.springframework.web.bind.annotation.RestController;

// RequestMapping, GetMapping, PostMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// RequestBody
import org.springframework.web.bind.annotation.RequestBody;
// Autowired
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

// LapsRecord Service, Entity, Request
import com.haram.haramtimer.service.LapsRecordService;
import com.haram.haramtimer.entity.LapsRecord;
import com.haram.haramtimer.lap.Lap;
import com.haram.haramtimer.request.LapsRecordRequest;
import com.haram.haramtimer.request.LapsRecordDeleteRequest;

// List
import java.util.List;
// HttpHeaders, MediaType
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/laps_record")
public class LapsRecordController {
    @Autowired
    LapsRecordService lapsRecordService;

    @GetMapping("/read")
    public List<LapsRecord> readAllLapsRecords() {
        return lapsRecordService.getAllLapsRecords();
    }

    @PostMapping("/save")
    public boolean saveLapsRecord(@RequestBody LapsRecordRequest lapsRecordRequest) {
        return lapsRecordService.saveLapsRecord(lapsRecordRequest.getLabel(), lapsRecordRequest.getLaps());
    }

    @PostMapping("/delete")
    public boolean deleteLapsRecord(@RequestBody LapsRecordDeleteRequest lapsRecordDeleteRequest) {
        return lapsRecordService.deleteLapsRecord(lapsRecordDeleteRequest.getId());
    }

    @PostMapping("/export_to_csv")
    public ResponseEntity<ByteArrayResource> exportToCsv(@RequestBody LapsRecordRequest lapsRecordRequest) {
        String label = lapsRecordRequest.getLabel();
        List<Lap> laps = lapsRecordRequest.getLaps();

        byte[] csvData = lapsRecordService.exportToCsvBytes(label, laps);

        // 응답 헤더 설정
        HttpHeaders headers = new HttpHeaders();

        // CONTENT_DISPOSITION 헤더를 추가하여 브라우저에게 이 내용이 파일 다운로드임을 알려줌
        // filename 파라미터에는 다운로드될 파일의 이름(label.csv)이 들어감
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + label + ".csv");

        // ByteArrayResource로 파일 반환
        return ResponseEntity.ok()
                .headers(headers) // 설정한 헤더를 응답에 추가
                .contentLength(csvData.length) // 응답 본문의 길이 설정
                .contentType(MediaType.parseMediaType("application/octet-stream")) // 응답 본문의 타입을 이진 데이터로 설정
                .body(new ByteArrayResource(csvData)); // 바이트 배열로부터 생성한 ByteArrayResource를 응답 본문으로 설정

    }
}
