package com.example.loading.repository;

import com.example.loading.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class TeamRepository {
    private final EntityManager em;

    public void save(Team team){
        em.persist(team);
    }

    public Team findById(Long id){
        return em.find(Team.class, id);
    }
}
