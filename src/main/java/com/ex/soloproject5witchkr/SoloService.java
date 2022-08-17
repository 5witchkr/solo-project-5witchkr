package com.ex.soloproject5witchkr;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class SoloService {

    public Member getMember() {
        return new Member(1, "홈길동");
    }
}