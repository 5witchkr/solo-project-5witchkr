package com.ex.soloproject5witchkr;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoloController {

    //전체회원조회
    @GetMapping("/all")
    public String getAllMembers(@RequestParam("page")int page){
        return "all"+page;
    }

    //조건검색
    @GetMapping("/membername")
    public String memberName(@RequestParam("name") String name) {
        return name;
    }


}
