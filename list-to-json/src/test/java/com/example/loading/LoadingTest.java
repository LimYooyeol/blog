//package com.example.loading;
//
//import com.example.loading.domain.Member;
//import com.example.loading.domain.Team;
//import com.example.loading.repository.MemberRepository;
//import com.example.loading.repository.TeamRepository;
//import jakarta.persistence.EntityManager;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//@Transactional
//public class LoadingTest {
//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    TeamRepository teamRepository;
//
//    @Autowired
//    EntityManager em;
//
//    @Test
//    public void 로딩_테스트(){
//        // 팀, 회원 저장
//        Team team = new Team();
//        team.setName("팀1");
//        teamRepository.save(team);
//
//        Member member = new Member();
//        member.setName("회원1");
//        member.setTeam(team);
//        memberRepository.save(member);
//
//        em.clear();
//
//        // 회원 조회
//        Member findMember = memberRepository.findById(member.getId());
//        System.out.println("===========");
//        System.out.println(findMember.getTeam().getClass());
//    }
//
//}
