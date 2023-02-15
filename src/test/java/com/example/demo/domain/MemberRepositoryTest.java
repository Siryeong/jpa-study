package com.example.demo.domain;

import com.example.demo.DemoApplicationTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest extends DemoApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(MemberRepositoryTest.class);

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
        Member member = Member.builder()
                .username("davi")
                .password("password")
                .build();

        // when
        memberRepository.save(member);

        // then
        assertThat(memberRepository.findAll().size()).isEqualTo(4);
    }

    @DisplayName("멤버 정보를 변경할 수 있다.")
    @Test
    void updateUser() {
        // given
        Member member = memberRepository.findById(1).orElseThrow();

        logger.debug(member.toString());

        // when
        Integer id = member.update(Member.builder().username("hello").password("world").build());
        memberRepository.save(member);

        // then
        Member expected = memberRepository.findById(id).orElseThrow();
        assertThat(member).isEqualTo(expected);
    }

    public void createUser() {
        Member member = Member.builder()
                .username("davi")
                .password("password")
                .build();

        // when
        memberRepository.save(member);
    }

    @DisplayName("멤버 정보를 삭제할 수 있다.")
    @Test
    void deleteUser() {
        // given
        Member member = memberRepository.findById(1).orElseThrow();

        // when
        memberRepository.delete(member);

        // then
        assertThat(memberRepository.findById(1).isEmpty()).isTrue();
    }
}