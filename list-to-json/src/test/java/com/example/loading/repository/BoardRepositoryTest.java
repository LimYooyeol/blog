package com.example.loading.repository;

import com.example.loading.domain.Board;
import com.example.loading.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager em;


    @Test
    public void 인기_게시물_조회(){
        // given
        Member member1 = new Member();
        member1.setName("회원1");
        Member member2 = new Member();
        member2.setName("회원2");
        memberRepository.save(member1);
        memberRepository.save(member2);

        Board board1 = new Board("제목1", "내용1", 3L, member1);
        Board board2 = new Board("제목2", "내용2", 11L, member1);
        Board board3 = new Board("제목3", "내용3", 6L, member2);
        boardRepository.save(board1);
        boardRepository.save(board2);
        boardRepository.save(board3);

        em.clear();

        // when
        boardRepository.findAllByViewDesc();
    }

}