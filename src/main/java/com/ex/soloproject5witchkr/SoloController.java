package com.ex.soloproject5witchkr;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SoloController {

    //전체회원조회
    @GetMapping("/all")
    public String getAllMembers(){
        return "hi";
    }

    //조건검색
    @GetMapping("/membername")
    public String memberName(@RequestParam("name") String name) {
        return name;
    }


}
