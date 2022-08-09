package com.makao.letter.contollers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PostControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void postPage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/post"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("등록하기")
        ));
  }

  @Test
  void post() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/post")
            .param("title", "나란 페페")
            .param("author", "페페")
            .param("content", "나란 페페는 누구?"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("글 등록이 완료 되었습니다")
        ));

    mockMvc.perform(MockMvcRequestBuilders.get("/posts"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("나란 페페")
        ));
  }
}
