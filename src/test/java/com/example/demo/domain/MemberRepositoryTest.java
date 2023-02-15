package com.example.demo.domain;

import com.example.demo.DemoApplicationTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest extends DemoApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("멤버를 조회할 수 있다.")
    @Test
    void selectUser() {
        // given
        Member member = Member.builder()
                .username("davi")
                .password("password")
                .build();
        Member savedMember = memberRepository.save(member);

        // when
        Member selectedMember = memberRepository.findById(savedMember.getMemberId()).orElseThrow();

        // then
        assertThat(selectedMember).isEqualTo(savedMember);
    }

    @DisplayName("새로운 멤버를 저장할 수 있다")
    @Test
    void saveUser() {
        // given
        Member member = new Member("davi", "password");

        // when
        memberRepository.save(member);

        // then
        assertThat(memberRepository.findAll().size()).isEqualTo(4);
    }
}