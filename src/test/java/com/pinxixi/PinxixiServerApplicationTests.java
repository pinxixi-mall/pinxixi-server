package com.pinxixi;

import com.pinxixi.common.ServiceResultEnum;
import com.pinxixi.utils.TokenUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class PinxixiServerApplicationTests {

    @Value("${pinxixi.jwt.header_auth}")
    private String headerAuth;

    @Test
    void testToken() {
        System.out.println(headerAuth);
        //TokenUtils.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMyIsImlzcyI6ImF1dGgwIiwiZXhwIjoxNjQ1NzUzODA3LCJ1c2VybmFtZSI6ImFkbWluMSJ9.on19sSa14UapJZhqPzGQJu9jIEUbXUR9h2gJygzfOhU");
    }

}
