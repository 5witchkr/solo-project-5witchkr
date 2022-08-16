package com.ex.soloproject5witchkr;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


//
import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SoloController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class SoloTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ReturnHi() throws Exception {
        this.mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hi")))
                .andDo(document("all"));
    }

    @Test
    public void ReturnName() throws Exception {
        this.mockMvc.perform(get("/membername").param("name", "홍길동"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("홍길동")))
                .andDo(document("name"));
    }

}
