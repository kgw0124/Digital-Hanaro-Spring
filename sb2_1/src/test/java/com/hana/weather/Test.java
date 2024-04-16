package com.hana.weather;

import com.hana.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
public class Test {
    @org.junit.jupiter.api.Test
    void contextLoads() throws IOException, ParseException {
        String key = "04670200d6dfdffa3a158c9401f2104a";
        String loc = "1835848";
        JSONObject jsonObject = (JSONObject) WeatherUtil.getWeather2(loc, key);
        log.info(String.valueOf(jsonObject));
    }
}
