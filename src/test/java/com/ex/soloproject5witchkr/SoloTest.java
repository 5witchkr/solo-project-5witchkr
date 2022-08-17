package com.ex.soloproject5witchkr;


import com.ex.soloproject5witchkr.common.RestDocsConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


//
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
@Import(RestDocsConfiguration.class)
public class SoloTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    SoloRepository soloRepository;

//    @Test
//    public void ReturnHi() throws Exception {
//
//        this.mockMvc.perform(get("/all").param("page", "1"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("all")))
//                .andDo(document("all"));
//    }
    @Test
    public void ReturnName() throws Exception {
        this.mockMvc.perform(get("/membername").param("name", "홍길동"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("홍길동")))
                .andDo(document("name"));
    }

    @Test
    @DisplayName("페이징")
    public void queryEvents() throws Exception {
//        // Given
//        IntStream.range(0, 30).forEach(this::generateEvent);

        // When
        this.mockMvc.perform(get("/all")
                        .param("page", "1"))
                // Then
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("member"));
    }

//    private void generateEvent(int index) {
//        Member member = Member.builder()
//                .id(index)
//                .name("홍길동")
//                .build();
//        this.soloRepository.save(member);
//    }



}
