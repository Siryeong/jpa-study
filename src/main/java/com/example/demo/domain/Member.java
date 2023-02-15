package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "member")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    private String username;
    private String password;

    @Builder
    private Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer update(Member member) {
        this.username = member.username;
        this.password = member.password;
        return this.memberId;
    }
}
