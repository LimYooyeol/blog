package com.lback.blog.repository;

import com.lback.blog.domain.Locker;
import com.lback.blog.domain.Member;
import com.lback.blog.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TeamRepositoryTest {
    @Autowired LockerRepository lockerRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired TeamRepository teamRepository;
    @Autowired
    EntityManager em;

    void insertData(){
        Locker locker1 = new Locker();
        locker1.setNumber(100L);
        Locker locker2 = new Locker();
        locker2.setNumber(200L);
        Locker locker3 = new Locker();
        locker3.setNumber(300L);
        Locker locker4 = new Locker();
        locker4.setNumber(400L);


        lockerRepository.save(locker1);
        lockerRepository.save(locker2);
        lockerRepository.save(locker3);
        lockerRepository.save(locker4);

        Member member1 = new Member();
        member1.setName("회원1-1");
        member1.setLocker(locker1);

        Member member2 = new Member();
        member2.setName("회원1-2");
        member2.setLocker(locker2);

        Member member3 = new Member();
        member3.setName("회원2-1");
        member3.setLocker(locker3);

        Member member4 = new Member();
        member4.setName("회원2-2");
        member4.setLocker(locker4);

        Team team1= new Team();
        team1.setName("팀 1");
        team1.addMember(member1);
        team1.addMember(member2);

        Team team2= new Team();
        team2.setName("팀 2");
        team2.addMember(member3);
        team2.addMember(member4);

        teamRepository.save(team1);
        teamRepository.save(team2);
    }

    @Test
    @Rollback(value = false)
    public void 팀_목록_v1(){
        insertData();
        em.flush();
        em.clear();
        List<Team> teams_v1 = teamRepository.getTeams_v1();

        System.out.println("===================");
        System.out.println(teams_v1);
        System.out.println("===================");
    }

    @Test
    public void 팀_목록_v2(){
        insertData();
        em.flush();
        em.clear();
        List<Team> teams_v2 = teamRepository.getTeams_v2();

        System.out.println("===================");
        System.out.println(teams_v2);
        System.out.println("===================");
    }

    @Test
    public void 팀_목록_v3(){

        insertData();
        em.flush();
        em.clear();
        System.out.println("===================");
        List<Team> teams_v3 = teamRepository.getTeams_v3();
        System.out.println("===================");

        System.out.println(teams_v3);
        System.out.println("===================");
    }

}