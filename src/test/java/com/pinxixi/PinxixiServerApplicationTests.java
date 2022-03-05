package com.pinxixi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PinXiXiServerApplicationTests {

    @Value("${server.port}")
    private Integer port;

    @Test
    void testSomething() {
        System.out.println(port);
    }

}
