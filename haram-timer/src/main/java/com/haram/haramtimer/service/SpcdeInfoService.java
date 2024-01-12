package com.haram.haramtimer.service;

// Service
import org.springframework.stereotype.Service;
// Autowired
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// List
import java.util.List;

// Holiday Entity, Repository
import com.haram.haramtimer.entity.Holiday;
import com.haram.haramtimer.repository.HolidayRepository;
import com.haram.haramtimer.response.holiDeInfoResponse.HoliDeInfoResponse;
import com.haram.haramtimer.response.holiDeInfoResponse.HolidayEvent;
import com.haram.haramtimer.response.holiDeInfoResponse.Response;

@Service
public class SpcdeInfoService {
        @Autowired
        HolidayRepository holidayRepository;

        private HoliDeInfoResponse getHoliDeInfoResponse(int solYear) throws IOException, InterruptedException {
                String apiKey = "Is%2By%2FR%2FvVmo8yO8vXFeiTMmqQtEuNffgv%2FPdYE4GzzEoW5lqf9qey9eGXR3aaA25f9FRDCLQ92OPQD5G1e5VeQ%3D%3D";
                String url = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo?"
                                + "solYear=" + solYear
                                + "&numOfRows=90"
                                + "&pageNo=1"
                                + "&totalCount=90"
                                + "&ServiceKey=" + apiKey
                                + "&_type=json";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                ObjectMapper objectMapper = new ObjectMapper();
                HoliDeInfoResponse holiDeInfoResponse = objectMapper.readValue(response.body(),
                                HoliDeInfoResponse.class);

                return holiDeInfoResponse;
        }

        public boolean saveHolidays(int solYear) {
                try {
                        Response response = getHoliDeInfoResponse(solYear).getResponse();
                        List<HolidayEvent> holiDeInfoItem = response.getBody().getItems().getItem();

                        for (HolidayEvent item : holiDeInfoItem) {
                                if (item.getIsHoliday().equals("Y")) { // 공휴일이면서 휴일일 경우
                                        String dateStr = Integer.toString(item.getLocdate()); // 정수형을 문자형으로 변환
                                        Holiday holiday = new Holiday(
                                                        item.getDateName(),
                                                        Integer.parseInt(dateStr.substring(0, 4)), // ex. 2024
                                                        Integer.parseInt(dateStr.substring(4, 6)) - 1, // ex. 01 -> 0
                                                        Integer.parseInt(dateStr.substring(6, 8)) // ex. 01 -> 1
                                        );
                                        holidayRepository.save(holiday);
                                }
                        }
                        return true;
                } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        return false;
                }
        }
}
