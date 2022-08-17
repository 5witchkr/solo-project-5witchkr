package com.ex.soloproject5witchkr;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {
    @Id
    private int id;

    @Column
    private String name;

    @Builder
    public Member(int id, String name) {
        id = this.id;
        name = this.name;
    }
}
