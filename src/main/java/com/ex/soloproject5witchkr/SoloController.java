package com.ex.soloproject5witchkr;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SoloController {

    private final SoloRepository soloRepository;

    //전체회원조회
    @GetMapping("/all")
    public ResponseEntity getAllMembers(Pageable pageable){
        Page<Member> page = this.soloRepository.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    //조건검색
    @GetMapping("/membername")
    public String memberName(@RequestParam("name") String name) {
        return name;
    }

}
