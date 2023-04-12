package com.lback.blog.repository;

import com.lback.blog.domain.Locker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class LockerRepository {

    private final EntityManager em;

    public Long save(Locker locker){
        em.persist(locker);

        return locker.getId();
    }
}
