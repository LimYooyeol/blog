package com.example.loading.repository;

import com.example.loading.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public void save(Board board){
        em.persist(board);
    }

    public List<Board> findAllByViewDesc(){
        String query = "" +
                " select b from Board b join fetch b.writer " +
                " order by b.view DESC";

        List<Board> result = em.createQuery(query)
                .getResultList();

        return result;
    }
}
