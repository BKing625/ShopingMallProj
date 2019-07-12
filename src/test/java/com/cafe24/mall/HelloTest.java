package com.cafe24.mall;

import com.cafe24.mall.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloService.class})
public class HelloTest {

    @Autowired
    HelloService helloService;

    @Test
    public void helloWorld(){
        String expected = "Hello World";
        assertThat(helloService.getHelloMessage()).isEqualTo(expected);
    }
}

