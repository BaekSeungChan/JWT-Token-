package com.qortmdcks.jwt;

import com.qortmdcks.jwt.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
class JwtApplicationTests {


    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
    }

    @Test
    void tokenCreate(){
        var claims = new HashMap<String, Object>();
        claims.put("user_id", 923);

        var expireAt = LocalDateTime.now().plusSeconds(30);

        var jwtToken = jwtService.create(claims, expireAt);

        System.out.println(jwtToken);
    }

    @Test
    void tokenValidation(){
        var token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTY5OTg1NjI5OH0.-2MB7UmmbIb0MyWP1bp8dzSWXePztbNSuGfe2PEdV1c";
        jwtService.validation(token);
    }
}
