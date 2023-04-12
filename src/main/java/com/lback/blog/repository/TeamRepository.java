package com.lback.blog.repository;

import com.lback.blog.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamRepository {
    private final EntityManager em;

    public Long save(Team team){
        em.persist(team);

        return team.getId();
    }


    public List<Team> getTeams_v1(){

        return em.createQuery(
                "select t from Team t" +
                        " join fetch t.members m" +
                        " join fetch m.locker l"
        )
                .getResultList();

    }

    public List<Team> getTeams_v2(){

        return em.createQuery(
                "select distinct t from Team t" +
                        " join fetch t.members m" +
                        " join fetch m.locker l"
        )
                .getResultList();

    }

    public List<Team> getTeams_v3(){

        return em.createQuery(
                "select t from Team t"
        )
                .getResultList();

    }


}
