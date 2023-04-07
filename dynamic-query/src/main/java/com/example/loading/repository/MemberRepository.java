package com.example.loading.repository;

import com.example.loading.domain.Member;
//import com.example.loading.domain.QMember;
import com.example.loading.domain.QMember;
import com.example.loading.domain.QTeam;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    private BooleanExpression nameLike(String name){
        if(name == null){
            return null;
        }
        return QMember.member.name.like("%" + name + "%");
    }

    private BooleanExpression numberEq(Long number){
        if(number == null){
            return null;
        }
        return QMember.member.number.eq(number);
    }
    public List<Member> findMembersV1(String name, Long number){
        JPAQuery<Member> query = new JPAQuery<>(em); // result type

        QMember member = QMember.member;

        List<Member> result = query.from(member)
                .where(
                    nameLike(name),
                    numberEq(number)
                )
                .fetch();

        return result;
    }

    public BooleanExpression teamNameLike(String teamName){
        if(teamName == null){
            return null;
        }

        return QTeam.team.name.like("%" + teamName + "%");
    }

    public List<Member> findMembersV2(String name, Long number, String teamName){
        JPAQuery<Member> query = new JPAQuery<>(em);

        QMember member = QMember.member;
        QTeam team = QTeam.team;

        List<Member> result = query.from(member)
                .join(member.team, team).fetchJoin()
                .where(
                        nameLike(name),
                        numberEq(number),
                        teamNameLike(teamName)
                )
                .fetch();

        return result;
    }


    public void save(Member member){
        em.persist(member);
    }

    public Member findById(Long id){
        return em.find(Member.class, id);
    }
}
