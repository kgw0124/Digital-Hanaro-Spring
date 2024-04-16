package com.hana;

import com.hana.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
class Sb2ApplicationTests {

    @Test
    void contextLoads() throws IOException, ParseException {
        String key = "NnOnJEKXvopIFIhBe2QgBXhLNfkDn1AyyY1IiMcKx2TutRSVVb8Cf9t%2FTQLz8p5moigWyrsLLrulQWrUP%2BjlMw%3D%3D";
        String loc = "109";
        JSONObject jsonObject = (JSONObject) WeatherUtil.getWeather(loc,key);
        log.info("------LOG------" + jsonObject.toJSONString());
    }

}
