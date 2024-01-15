package com.haram.haramtimer.service;

// Service
import org.springframework.stereotype.Service;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
// Autowired
import org.springframework.beans.factory.annotation.Autowired;

// LapsRecord Repository, Entity
import com.haram.haramtimer.entity.LapsRecord;
import com.haram.haramtimer.lap.Lap;
import com.haram.haramtimer.lap.StopwatchTime;
import com.haram.haramtimer.repository.LapsRecordRepository;

// CSVWriter, OutputStreamWriter
import com.opencsv.CSVWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
// List
import java.util.List;

@Service
public class LapsRecordService {
    @Autowired
    LapsRecordRepository lapsRecordRepository;

    public List<LapsRecord> getAllLapsRecords() {
        return lapsRecordRepository.findAll();
    }

    public boolean saveLapsRecord(String label, List<Lap> laps) {
        try {
            lapsRecordRepository.save(new LapsRecord(label, laps));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteLapsRecord(Long id) {
        try {
            lapsRecordRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte[] exportToCsvBytes(String label, List<Lap> laps) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))) {

            // 헤더 컬럼 추가
            String[] header = { "Lap Number", "World Time", "Total Time" };
            csvWriter.writeNext(header);

            // 데이터 추가
            for (Lap lap : laps) {
                String[] data = {
                        String.valueOf(lap.getLapNumber()),
                        formatTime(lap.getWorldTime()),
                        formatTime(lap.getTotalTime())
                };
                csvWriter.writeNext(data);
            }

            csvWriter.flush();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 시간을 포맷팅하는 메서드
    private String formatTime(StopwatchTime stopwatchTime) {
        return String.format("%02dhr %02dmin %02dsec %02dms",
                stopwatchTime.getHours(), stopwatchTime.getMinutes(), stopwatchTime.getSeconds(),
                stopwatchTime.getMilliseconds());
    }
}
