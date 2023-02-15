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
    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
