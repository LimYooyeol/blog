package com.example.loading.repository;

import com.example.loading.domain.Member;
import com.example.loading.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private EntityManager em;

    @Test
    public void 이름_번호_검색_테스트(){
        // 팀, 멤버 추가
        Team team = new Team("팀 1");
        teamRepository.save(team);

        Member member1 = new Member("홍길동", 1L, team);
        Member member2 = new Member("김갑동", 2L, team);
        Member member3 = new Member("임꺽정", 3L, team);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // 영속성 컨텍스트 초기화
        em.clear();

        // 검색(조건x)
        List<Member> anyMembers = memberRepository.findMembersV1(null, null);
        List<Member> findMembers = memberRepository.findMembersV1("동", 2L);

        System.out.println(anyMembers);
        System.out.println(findMembers);
    }

    @Test
    public void 이름_번호_팀명_검색_테스트(){
        // 팀, 멤버 추가
        Team team1 = new Team("팀 1");
        Team team2 = new Team("팀 2");
        teamRepository.save(team1);
        teamRepository.save(team2);


        Member member1 = new Member("홍길동", 1L, team1);
        Member member2 = new Member("김갑동", 2L, team2);
        Member member3 = new Member("임꺽정", 3L, team1);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // 영속성 컨텍스트 초기화
        em.clear();

        // 이름에 "동"이 들어가고,
        // 번호는 상관없으며,
        // 팀 이름에 2가 들어가는
        // 멤버 검색
        List<Member> findMembers = memberRepository.findMembersV2("동", null, "2");

        System.out.println(findMembers);
    }

}