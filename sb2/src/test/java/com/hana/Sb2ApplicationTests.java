package com.hana;

import com.hana.app.data.dto.CustDto;

import com.hana.util.NcpUtil;
import com.hana.util.StringEnc;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@SpringBootTest
@Slf4j
class Sb2ApplicationTests {
    @Value("${app.key.ncp-id}")
    String ncpId;
    @Value("${app.key.ncp-secret}")
    String ncpSecret;
    @Test
    void contextLoads() {
        String text = "변우석은 정말 잘생겼다.";
        JSONObject obj = (JSONObject) NcpUtil.getSentiment(ncpId, ncpSecret, text);
        log.info(obj.toJSONString());
    }
}
