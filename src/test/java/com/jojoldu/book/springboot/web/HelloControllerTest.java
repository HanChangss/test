package com.jojoldu.book.springboot.web;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class) // 1 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.
// 여기서는 springRunner라는 스프링 실행자를 사용합니다.
// 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역활을 합니다.
@WebMvcTest(controllers = HelloController.class) // 2 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있습니다. 나머지는 불가능
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 이 클래스를 통해 HTTP GET,POST 등에 대한 API 테스트를 할 수 있습니다.

    @Test
    public void hello_test() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증합니다.
                .andExpect(content().string(hello)); //응답 본문의 내용을 검증합니다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk()) // 상태값 검증하는 부분
                .andExpect(jsonPath("$.name", is(name))) // jsonPath는 json 응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
